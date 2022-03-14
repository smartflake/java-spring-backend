package com.services.app.infra.model.request;

import com.services.app.infra.entity.Company;
import com.services.app.infra.model.GenericRequest;
import lombok.*;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class SaveReviewRequest extends BaseRequest implements GenericRequest {

    private int rating;

    private String companyReview;

    private String companyId;

    @Builder
    public SaveReviewRequest(int rating, String companyReview, String companyId) {
        this.rating = rating;
        this.companyReview = companyReview;
        this.companyId = companyId;
    }
}
