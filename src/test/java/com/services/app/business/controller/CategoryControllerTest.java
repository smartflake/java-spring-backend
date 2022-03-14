package com.services.app.business.controller;

import com.services.app.infra.entity.Category;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.GetAllCategoryResponse;
import com.services.app.infra.repository.CategoryRepository;
import com.services.app.util.enums.ResponseEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient
class CategoryControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
     void saveCategory(){
        new Category();
        var category = Category.builder().type("Cleaning").build();

        webTestClient
                .post()
                .uri("/category")
                .bodyValue(category)
                .exchange()
                .expectBody(BaseResponse.class)
                .value(resp -> {
                    assertThat(resp.getResponseCode().equals(String.valueOf(ResponseEnum.SUCCESS.getCode())));
                    assertThat(resp.getResponseDescription().equals("Category Saved"));
                    assertThat(resp.getStatus().equals(ResponseEnum.SUCCESS.getMessage()));
                    categoryRepository.delete(categoryRepository.findByType(category.getType()).get());
                });
    }

    @Test
    void getCategory(){
        webTestClient
                .get()
                .uri("/category")
                .exchange()
                .expectBody(GetAllCategoryResponse.class)
                .value(resp ->{
                    assertThat(resp.getResponseCode().equals(String.valueOf(ResponseEnum.SUCCESS.getCode())));
                    assertThat(resp.getResponseDescription().equals("Success"));
                    assertThat(resp.getStatus().equals(ResponseEnum.SUCCESS.getMessage()));
                });


    }
}