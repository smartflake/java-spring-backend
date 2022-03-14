package com.services.app.business.controller;

import com.services.app.business.service.ReviewService;
import com.services.app.infra.model.request.SaveReviewRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.GetReviewResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public BaseResponse saveReview(@RequestBody SaveReviewRequest request){
        return reviewService.saveReview(request);
    }

    @GetMapping("/{companyId}")
    public GetReviewResponse getCompanyReview(@PathVariable String companyId){
        return reviewService.getCompanyReviews(companyId);
    }
}
