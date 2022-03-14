package com.services.app.infra.model.response;

import com.services.app.infra.entity.Request;
import com.services.app.infra.model.GenericResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Set;

/**
 * @author Ashwani Pandey
 * @created 25/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CompanyRequestResponse extends BaseResponse implements GenericResponse {

    private Set<Request> requests;

    @Builder

    public CompanyRequestResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, Set<Request> requests) {
        super(httpStatus, status, responseCode, responseDescription);
        this.requests = requests;
    }
}
