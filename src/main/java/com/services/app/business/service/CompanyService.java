package com.services.app.business.service;

import com.services.app.infra.entity.Company;
import com.services.app.infra.model.request.AddCategoryRequest;
import com.services.app.infra.model.request.RegisterRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.CompanyRequestResponse;
import com.services.app.infra.model.response.RegisterResponse;

import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */
public interface CompanyService {
    public Optional<Company> findByEmail(String email);

    Optional<Company> findById(String id);

    RegisterResponse register(RegisterRequest request);

    BaseResponse addCategory(AddCategoryRequest request);

    CompanyRequestResponse getRequest(String email);
}
