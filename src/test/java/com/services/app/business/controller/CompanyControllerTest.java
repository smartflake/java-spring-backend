package com.services.app.business.controller;

import com.services.app.infra.entity.Company;
import com.services.app.infra.model.request.LoginRequest;
import com.services.app.infra.model.request.SaveCompanyRequest;
import com.services.app.infra.model.response.LoginResponse;
import com.services.app.infra.model.response.RegisterResponse;
import com.services.app.infra.repository.CompanyRepository;
import com.services.app.util.enums.ResponseEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient
class CompanyControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void saveCompanyTest(){
        var company = SaveCompanyRequest.builder()
                .name("Test")
                .email("test2e@gmail.com")
                .commercialRegister("TEsttest")
                .addressStreet("Street 1")
                .contactNumber("9878654321")
                .location("Test Location")
                .postalCode("123123")
                .country("Switzerland")
                .website("http://localhost.com")
                .build();

        webTestClient
                .post()
                .uri("/company/register")
                .bodyValue(company)
                .exchange()
                .expectBody(RegisterResponse.class)
                .value(resp ->{
                    assertThat(resp.getResponseCode().equals(String.valueOf(ResponseEnum.SUCCESS.getCode())));
                    assertThat(resp.getStatus().equals(ResponseEnum.SUCCESS.getMessage()));
                    companyRepository.delete(resp.getCompany());
                });

    }

    @Test
    void loginTest(){
        var login = LoginRequest.builder()
                .email("test3e@gmail.com")
                .password("test123")
                .build();

        webTestClient
                .post()
                .uri("/company/login")
                .bodyValue(login)
                .exchange()
                .expectBody(LoginResponse.class)
                .value(resp -> {
                    assertThat(resp.getResponseCode().equals(String.valueOf(ResponseEnum.SUCCESS.getCode())));
                    assertThat(resp.getStatus().equals(ResponseEnum.SUCCESS.getMessage()));
                        });
    }

    @Test
    void shouldFailLogin(){
        var login = LoginRequest.builder()
                .email("test3e@gmail.com")
                .password("wrongPassword")
                .build();

        webTestClient
                .post()
                .uri("/company/login")
                .bodyValue(login)
                .exchange()
                .expectBody(LoginResponse.class)
                .value(resp -> {
                    assertThat(resp.getResponseCode().equals(String.valueOf(ResponseEnum.FAILURE.getCode())));
                    assertThat(resp.getStatus().equals(ResponseEnum.FAILURE.getMessage()));
                });
    }


}