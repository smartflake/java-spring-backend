package com.services.app.infra.model.response;

import com.services.app.infra.entity.Company;
import com.services.app.infra.model.GenericResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RegisterResponse extends BaseResponse implements GenericResponse {

    private Company company;

    @Builder
    public RegisterResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, Company company) {
        super(httpStatus, status, responseCode, responseDescription);
        this.company = company;
    }
}
