package com.services.app.infra.model.response;

import com.services.app.infra.entity.Category;
import com.services.app.infra.model.GenericResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GetAllCategoryResponse extends BaseResponse implements GenericResponse {

    List<Category> categories;

    @Builder
    public GetAllCategoryResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, List<Category> categories) {
        super(httpStatus, status, responseCode, responseDescription);
        this.categories = categories;
    }
}
