package com.services.app.business.service.impl;

import com.services.app.business.service.CompanyService;
import com.services.app.business.service.ReviewService;
import com.services.app.util.translator.GenericTranslator;
import com.services.app.infra.entity.Company;
import com.services.app.infra.entity.Review;
import com.services.app.infra.model.request.SaveReviewRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.GetReviewResponse;
import com.services.app.infra.repository.ReviewRepository;
import com.services.app.util.response_builders.BaseFailure;
import com.services.app.util.response_builders.BaseSuccess;
import com.services.app.util.response_builders.failure.FailedResponse;
import com.services.app.util.response_builders.success.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private GenericTranslator genericTranslator;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private BaseSuccess baseSuccess;

    @Autowired
    private SuccessResponse successResponse;

    @Autowired
    private FailedResponse failedResponse;

    @Autowired
    private BaseFailure baseFailure;

    @Override
    public BaseResponse saveReview(SaveReviewRequest request) {
        Optional<Company> company =  companyService.findById(request.getCompanyId());
        if (company.isEmpty()){
            return baseFailure.baseFailResponse("Company Not Present");
        }
        else {
            Review review = genericTranslator.translateSaveReview(request,company.get());
            reviewRepository.save(review);
            return baseSuccess.baseSuccessResponse("Review created");
        }
    }

    @Override
    public GetReviewResponse getCompanyReviews(String companyId) {
        Optional<Company> company =  companyService.findById(companyId);
        if (company.isEmpty()){
            return failedResponse.getReviewFailed();
        } else {
            List<Review> reviews = reviewRepository.findByCompany(company.get());
            return successResponse.getReviewSuccess(reviews);
        }
    }


}
