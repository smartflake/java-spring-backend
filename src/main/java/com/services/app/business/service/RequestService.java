package com.services.app.business.service;

import com.services.app.infra.model.request.UserRequestDTO;
import com.services.app.infra.model.response.GetUsersRequestResponse;
import com.services.app.infra.model.response.SaveRequestResponse;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
public interface RequestService {
    SaveRequestResponse saveRequest(UserRequestDTO request);

    GetUsersRequestResponse getUsersRequest(String userId);
}
