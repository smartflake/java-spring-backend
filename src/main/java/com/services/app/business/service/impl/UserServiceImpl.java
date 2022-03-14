package com.services.app.business.service.impl;

import com.services.app.business.service.UserService;
import com.services.app.util.translator.GenericTranslator;
import com.services.app.infra.model.request.SaveUserRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.repository.UserRepository;
import com.services.app.util.response_builders.BaseFailure;
import com.services.app.util.response_builders.BaseSuccess;
import com.services.app.util.response_builders.failure.FailedResponse;
import com.services.app.util.response_builders.success.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SuccessResponse successResponse;

    @Autowired
    private FailedResponse failedResponse;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private BaseFailure baseFailure;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GenericTranslator genericTranslator;

    @Override
    public BaseResponse saveUser(SaveUserRequest request) {
        var user =    genericTranslator.translateSaveUser(request);
        userRepository.save(user);
        return baseSuccess.baseSuccessResponse("User Created");
    }
}
