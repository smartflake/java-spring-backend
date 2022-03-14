package com.services.app.business.service;

import com.services.app.infra.entity.Request;
import com.services.app.infra.model.response.BaseResponse;

/**
 * @author Ashwani Pandey
 * @created 24/02/2022
 */
public interface NotificationService {
    void createNotification(Request userRequest);

//    BaseResponse sendNotification();
}
