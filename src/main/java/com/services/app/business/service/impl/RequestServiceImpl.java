package com.services.app.business.service.impl;

import com.services.app.business.service.NotificationService;
import com.services.app.business.service.RequestService;
import com.services.app.util.translator.GenericTranslator;
import com.services.app.infra.entity.*;
import com.services.app.infra.model.request.UserRequestDTO;
import com.services.app.infra.model.response.GetUsersRequestResponse;
import com.services.app.infra.model.response.SaveRequestResponse;
import com.services.app.infra.repository.*;
import com.services.app.util.response_builders.BaseFailure;
import com.services.app.util.response_builders.BaseSuccess;
import com.services.app.util.response_builders.failure.FailedResponse;
import com.services.app.util.response_builders.success.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestLifecycleRepository lifecycleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

   @Autowired
   private NotificationService notificationService;

    @Autowired
    private GenericTranslator genericTranslator;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private SuccessResponse successResponse;

    @Autowired
    private FailedResponse failedResponse;

    @Autowired
    private BaseFailure baseFailure;

    @Override
    public SaveRequestResponse saveRequest(UserRequestDTO request) {
        Optional<User> userFetched  = userRepository.findByEmail(request.getUser().getEmail());
        Optional<Category> category = categoryRepository.findById(request.getCategoryId());

        // If user is not present add the user
        if(userFetched.isEmpty()){
            var user =  userRepository.save(genericTranslator.translateSaveUser(request.getUser()));
            if(category.isPresent()){
                var userRequest = genericTranslator.translateRequest(user, category.get(),request);
                requestRepository.save(userRequest);
                var requestLifecycle = RequestLifecycle.builder()
                        .createdAt(new Date())
                        .currentState("New")
                        .request(userRequest)
                        .build();
                lifecycleRepository.save(requestLifecycle);
                notificationService.createNotification(userRequest);
                return successResponse.saveRequestSuccess(userRequest);
            }
            else {
                return failedResponse.SaveRequestFailed("Category Not Present");
            }
        } else {
            if(category.isPresent()){
                var userRequest = genericTranslator.translateRequest(userFetched.get(), category.get(),request);
                requestRepository.save(userRequest);
                var requestLifecycle = RequestLifecycle.builder()
                        .createdAt(new Date())
                        .currentState("New")
                        .request(userRequest)
                        .build();
                lifecycleRepository.save(requestLifecycle);
                notificationService.createNotification(userRequest);
                return successResponse.saveRequestSuccess(userRequest);
            }
            else {
                return failedResponse.SaveRequestFailed("Category Not Present");
            }
        }
    }

    @Override
    public GetUsersRequestResponse getUsersRequest(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
           return failedResponse.getUserRequestFailed();
        } else {
            List<Request> requests = requestRepository.findAllByUser(user.get());
            return successResponse.getAllUserRequest(requests);
        }
    }
}
