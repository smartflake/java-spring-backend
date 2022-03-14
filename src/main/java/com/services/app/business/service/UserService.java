package com.services.app.business.service;

import com.services.app.infra.model.request.SaveUserRequest;
import com.services.app.infra.model.response.BaseResponse;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
public interface UserService {
    BaseResponse saveUser(SaveUserRequest request);
}
