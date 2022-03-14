package com.services.app.business.service.impl;

import com.services.app.business.service.CompanyService;
import com.services.app.util.translator.GenericTranslator;
import com.services.app.infra.entity.Company;
import com.services.app.infra.model.request.AddCategoryRequest;
import com.services.app.infra.model.request.RegisterRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.CompanyRequestResponse;
import com.services.app.infra.model.response.RegisterResponse;
import com.services.app.infra.repository.CategoryRepository;
import com.services.app.infra.repository.CompanyRepository;
import com.services.app.util.response_builders.BaseFailure;
import com.services.app.util.response_builders.BaseSuccess;
import com.services.app.util.response_builders.failure.FailedResponse;
import com.services.app.util.response_builders.success.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private GenericTranslator genericTranslator;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private SuccessResponse successResponse;

    @Autowired
    private FailedResponse failedResponse;

    @Autowired
    private BaseFailure baseFailure;

    @Override
    public Optional<Company> findByEmail(String email) {
        return companyRepository.findByEmail(email);
    }

    @Override
    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Optional<Company> companyOptional = companyRepository.findByEmail(request.getEmail());
        Optional<Company> commercialNumber = companyRepository.findByCommercialRegister(request.getCommercialRegister());
        if(companyOptional.isEmpty() && commercialNumber.isEmpty()){

            var company = genericTranslator.translateRegisterCompany(request);
            companyRepository.save(company);
            return successResponse.RegisterSuccess(company);
        } else {
            if(companyOptional.isPresent())
                return failedResponse.registerFailed("Company Already Present");
            else
                return failedResponse.registerFailed("Commercial Number Already Present");
        }
    }

    @Override
    public BaseResponse addCategory(AddCategoryRequest request) {
        Optional<Company> companyOptional = companyRepository.findById(request.getCompanyId());
        if(companyOptional.isEmpty()){
            return baseFailure.baseFailResponse("Company Not Found");
        } else {
            var company = companyOptional.get();
            company.getCategories().addAll(request.getCategories());
            categoryRepository.saveAll(request.getCategories());
            companyRepository.save(company);
            return baseSuccess.baseSuccessResponse("Categories Added");
        }
    }

    @Override
    public CompanyRequestResponse getRequest(String email) {
        Optional<Company> companyOptional = companyRepository.findByEmail(email);
        if(companyOptional.isEmpty()){
            return failedResponse.getRequestFailed();
        } else {
            var company = companyOptional.get();
            return successResponse.getRequestSuccess(company.getRequests());
        }

    }
}
