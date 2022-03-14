package com.services.app.business.controller;

import com.services.app.business.service.CompanyService;
import com.services.app.infra.entity.Company;
import com.services.app.infra.model.request.AddCategoryRequest;
import com.services.app.infra.model.request.LoginRequest;
import com.services.app.infra.model.request.RegisterRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.CompanyRequestResponse;
import com.services.app.infra.model.response.LoginResponse;
import com.services.app.infra.model.response.RegisterResponse;
import com.services.app.util.response_builders.failure.FailedResponse;
import com.services.app.util.response_builders.success.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FailedResponse failedResponse;

    @Autowired
    private SuccessResponse successResponse;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        Optional<Company> company = companyService.findByEmail(request.getEmail());
       if(company.isEmpty()){
           return failedResponse.loginFailed();
       } else {
           var comFetched = company.get();
           if(comFetched.getPassword().equals(request.getPassword())){
               return successResponse.loginSuccess(comFetched);
           } else {
               return failedResponse.loginFailed();
           }
       }
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        return companyService.register(request);
    }


    @PostMapping("/addCategory")
    public BaseResponse addCategory(@RequestBody AddCategoryRequest request){
        return companyService.addCategory(request);
    }

    @PostMapping("/{email}/request")
    public CompanyRequestResponse getRequests(@PathVariable String email){
        return companyService.getRequest(email);
    }

}
