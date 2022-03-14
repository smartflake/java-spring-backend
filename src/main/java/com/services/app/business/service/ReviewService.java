package com.services.app.business.service;

import com.services.app.infra.model.request.SaveReviewRequest;
import com.services.app.infra.model.response.BaseResponse;
import com.services.app.infra.model.response.GetReviewResponse;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
public interface ReviewService {

    BaseResponse saveReview(SaveReviewRequest request);

    GetReviewResponse getCompanyReviews(String companyId);
}
