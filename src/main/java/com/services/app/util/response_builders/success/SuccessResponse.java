package com.services.app.util.response_builders.success;

import com.services.app.infra.entity.Category;
import com.services.app.infra.entity.Company;
import com.services.app.infra.entity.Request;
import com.services.app.infra.entity.Review;
import com.services.app.infra.model.response.*;
import com.services.app.util.enums.ResponseEnum;
import com.services.app.util.response_builders.BaseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Service
public class SuccessResponse {

    @Autowired
    private BaseSuccess baseSuccess;

    public LoginResponse loginSuccess(Company company){
        var resp = baseSuccess.baseSuccessResponse("Login Success");
        return LoginResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .company(company)
                .build();
    }

    public GetAllCategoryResponse getAllCategory(List<Category> categories) {
        var resp = baseSuccess.baseSuccessResponse(ResponseEnum.SUCCESS.getMessage());
        return GetAllCategoryResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .categories(categories)
                .build();
    }

    public GetReviewResponse getReviewSuccess(List<Review> reviews) {
        var resp = baseSuccess.baseSuccessResponse(ResponseEnum.SUCCESS.getMessage());
        return GetReviewResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .reviews(reviews)
                .build();
    }

    public SaveRequestResponse saveRequestSuccess(Request userRequest) {
        var resp = baseSuccess.baseSuccessResponse(ResponseEnum.SUCCESS.getMessage());
        return SaveRequestResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .request(userRequest)
                .build();
    }

    public GetUsersRequestResponse getAllUserRequest(List<Request> requests) {
        var resp = baseSuccess.baseSuccessResponse(ResponseEnum.SUCCESS.getMessage());
        return GetUsersRequestResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .requests(requests)
                .build();
    }

    public RegisterResponse RegisterSuccess(Company company) {
        var resp = baseSuccess.baseSuccessResponse(ResponseEnum.SUCCESS.getMessage());
        return RegisterResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .company(company)
                .build();
    }


    public CompanyRequestResponse getRequestSuccess(Set<Request> requests) {
        var resp = baseSuccess.baseSuccessResponse(ResponseEnum.SUCCESS.getMessage());
        return CompanyRequestResponse.builder()
                .status(resp.getStatus())
                .responseDescription(resp.getResponseDescription())
                .responseCode(resp.getResponseCode())
                .httpStatus(resp.getHttpStatus())
                .requests(requests)
                .build();
    }
}
