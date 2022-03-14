package com.services.app.business.controller;

import com.services.app.business.service.NotificationService;
import com.services.app.infra.model.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

//    @GetMapping("/send")
//    public BaseResponse sendNotification(){
//        return notificationService.sendNotification();
//    }
}
