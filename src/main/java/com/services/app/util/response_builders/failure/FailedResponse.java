package com.services.app.util.response_builders.failure;

import com.services.app.infra.model.response.*;
import com.services.app.util.response_builders.BaseFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */

@Service
public class FailedResponse {

    @Autowired
    private BaseFailure baseFailure;

    public LoginResponse loginFailed(){
        var resp = baseFailure.baseFailResponse("Login Failed");
        return LoginResponse.builder()
                .company(null)
                .httpStatus(resp.getHttpStatus())
                .responseCode(resp.getResponseCode())
                .responseDescription(resp.getResponseDescription())
                .status(resp.getStatus())
                .build();
    }

    public GetReviewResponse getReviewFailed() {
        var resp = baseFailure.baseFailResponse("Company Not Present");
        return GetReviewResponse.builder()
                .httpStatus(resp.getHttpStatus())
                .responseCode(resp.getResponseCode())
                .responseDescription(resp.getResponseDescription())
                .status(resp.getStatus())
                .build();
    }

    public SaveRequestResponse SaveRequestFailed(String description) {
        var resp = baseFailure.baseFailResponse(description);
        return SaveRequestResponse.builder()
                .httpStatus(resp.getHttpStatus())
                .responseCode(resp.getResponseCode())
                .responseDescription(resp.getResponseDescription())
                .status(resp.getStatus())
                .build();
    }

    public GetUsersRequestResponse getUserRequestFailed() {
        var resp = baseFailure.baseFailResponse("User Not Present");
        return GetUsersRequestResponse.builder()
                .httpStatus(resp.getHttpStatus())
                .responseCode(resp.getResponseCode())
                .responseDescription(resp.getResponseDescription())
                .status(resp.getStatus())
                .build();
    }

    public RegisterResponse registerFailed(String description) {
        var resp = baseFailure.baseFailResponse(description);
        return RegisterResponse.builder()
                .httpStatus(resp.getHttpStatus())
                .responseCode(resp.getResponseCode())
                .responseDescription(resp.getResponseDescription())
                .status(resp.getStatus())
                .build();
    }

    public CompanyRequestResponse getRequestFailed() {
        var resp = baseFailure.baseFailResponse("Company Not present");
        return  CompanyRequestResponse.builder()
                .httpStatus(resp.getHttpStatus())
                .responseCode(resp.getResponseCode())
                .responseDescription(resp.getResponseDescription())
                .status(resp.getStatus())
                .build();
    }
}
