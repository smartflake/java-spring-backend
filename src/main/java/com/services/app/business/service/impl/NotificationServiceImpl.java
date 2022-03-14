package com.services.app.business.service.impl;

import com.services.app.business.service.GeoLocationService;
import com.services.app.business.service.MailService;
import com.services.app.business.service.NotificationService;
import com.services.app.infra.entity.*;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.repository.*;
import com.services.app.util.constants.StatusConstants;
import com.services.app.util.response_builders.BaseFailure;
import com.services.app.util.response_builders.BaseSuccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@Service
@EnableScheduling
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private RequestLifecycleRepository requestLifecycleRepository;

    @Autowired
    private NotificationLifecycleRepository notificationLifecycleRepository;

    @Autowired
    private GeoLocationService geoLocationService;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private BaseFailure baseFailure;

    @Autowired
    private BaseSuccess baseSuccess;

    @Override
    public void createNotification(Request request) {

        var notification = Notification
                .builder()
                .request(request)
                .status(StatusConstants.DRAFT)
                .build();
        notificationRepository.save(notification);
        var notificationLifecycle = NotificationLifecycle.builder()
                .createdAt(new Date())
                .currentState(StatusConstants.DRAFT)
                .notification(notification)
                .notificationId(notification.getId())
                .build();
        notificationLifecycleRepository.save(notificationLifecycle);
    }

//    @Override
    @Scheduled(fixedDelay = 15000)
    public void sendNotification() {
        log.info("Sending notifications");
        // get all notifications that are in draft state
        List<Notification> notifications = notificationRepository.findAllByStatus("Draft");
        List<Company> companies = companyRepository.findAll();

        for(Notification notification : notifications) {

            var request = notification.getRequest();

            // find the nearest companies notification draft -> new
            notification = geoLocationService.findNearestCompanies(notification, companies);

            notification.setStatus(StatusConstants.NEW);
            notificationRepository.save(notification);
            var notificationLifecycle = NotificationLifecycle.builder()
                    .createdAt(new Date())
                    .previousState(StatusConstants.DRAFT)
                    .currentState(StatusConstants.NEW)
                    .notification(notification)
                    .notificationId(notification.getId())
                    .build();
            notificationLifecycleRepository.save(notificationLifecycle);

            // generate email notification new -> in progress request  new -> processing
            generateEmailAndSend(notification,request);

        }
//        return baseSuccess.baseSuccessResponse("Notifications sent");
    }

    public void generateEmailAndSend(Notification notification,Request request){
        var content = String.format("Dear, %n  \t %s has raised a request for %s. %n contact no: %s " +
                        "%n email: %s",
                notification.getRequest().getUser().getFirstname(),
                notification.getRequest().getCategory().getType(),
                notification.getRequest().getUser().getContactNo(),
                notification.getRequest().getUser().getEmail()
                );

        List<Company> companies = notification.getCompanies();
        // generate email (notification new -> in progress) (request  new -> processing)
        var notificationLifecycle1 = NotificationLifecycle.builder()
                .createdAt(new Date())
                .previousState(notification.getStatus())
                .currentState(StatusConstants.IN_PROGRESS)
                .notificationId(notification.getId())
                .notification(notification)
                .build();
        var requestLifeCycle = RequestLifecycle.builder()
                .previousState(request.getStatus())
                .currentState(StatusConstants.PROCESSING)
                .request(request)
                .build();
        request.setStatus(StatusConstants.PROCESSING);
        requestRepository.save(request);
        requestLifecycleRepository.save(requestLifeCycle);

        notificationLifecycleRepository.save(notificationLifecycle1);
        notification.setStatus(StatusConstants.IN_PROGRESS);
        notificationRepository.save(notification);
        try{
            for(Company company: companies){
                var mail = Mail.builder()
                        .mailTo(company.getEmail())
                        .mailFrom("testingcompero12@gmail.com")
                        .mailContent(content)
                        .mailSubject(notification.getRequest().getCategory().getType()+ " request from "
                                + notification.getRequest().getUser().getFirstname())
                        .build();
                mailService.sendEmail(mail);
                company.getRequests().add(request);
                company.setAmountDue(company.getAmountDue()+1);
                companyRepository.save(company);
            }
            var notificationLifecycle2 = NotificationLifecycle.builder()
                    .createdAt(new Date())
                    .previousState(notification.getStatus())
                    .currentState(StatusConstants.COMPLETE)
                    .notification(notification)
                    .notificationId(notification.getId())
                    .build();
            notificationLifecycleRepository.save(notificationLifecycle2);
            notification.setStatus(StatusConstants.COMPLETE);
            notificationRepository.save(notification);

            var requestLifeCycle1 = RequestLifecycle.builder()
                    .previousState(request.getStatus())
                    .currentState(StatusConstants.SENT)
                    .request(request)
                    .build();
            request.setStatus(StatusConstants.SENT);
            requestRepository.save(request);
            requestLifecycleRepository.save(requestLifeCycle1);

        } catch (Exception ex){
            var notificationLifecycle3 = NotificationLifecycle.builder()
                    .createdAt(new Date())
                    .previousState(notification.getStatus())
                    .currentState(StatusConstants.FAILED)
                    .notification(notification)
                    .notificationId(notification.getId())
                    .build();
            notificationLifecycleRepository.save(notificationLifecycle3);
            notification.setStatus(StatusConstants.FAILED);
            notificationRepository.save(notification);
        }
    }
}
