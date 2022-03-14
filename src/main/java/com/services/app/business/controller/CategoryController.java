package com.services.app.business.controller;

import com.services.app.business.service.CategoryService;
import com.services.app.infra.entity.Category;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.GetAllCategoryResponse;
import com.services.app.util.response_builders.BaseFailure;
import com.services.app.util.response_builders.BaseSuccess;
import com.services.app.util.response_builders.failure.FailedResponse;
import com.services.app.util.response_builders.success.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private SuccessResponse successResponse;

    @Autowired
    private FailedResponse failedResponse;

    @Autowired
    private BaseFailure baseFailure;

    @PostMapping
    public BaseResponse saveCategory(@RequestBody Category request){
        Optional<Category> fetchedCategory = categoryService.findByType(request.getType());
        if(fetchedCategory.isEmpty()){
            categoryService.save(request);
            return baseSuccess.baseSuccessResponse("Category Saved");
        }
        else{
            return baseFailure.baseFailResponse("Category Already Present");
        }
    }

    @GetMapping
    public GetAllCategoryResponse getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return successResponse.getAllCategory(categories);

    }
}
