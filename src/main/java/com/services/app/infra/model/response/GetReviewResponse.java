package com.services.app.infra.model.response;

import com.services.app.infra.entity.Review;
import com.services.app.infra.model.GenericResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GetReviewResponse extends BaseResponse implements GenericResponse {

    private List<Review> reviews;

    @Builder
    public GetReviewResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, List<Review> reviews) {
        super(httpStatus, status, responseCode, responseDescription);
        this.reviews = reviews;
    }
}
