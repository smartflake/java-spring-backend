package com.services.app.infra.model.response;

import com.services.app.infra.entity.Request;
import com.services.app.infra.model.GenericResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author Ashwani Pandey
 * @created 23/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GetUsersRequestResponse extends BaseResponse implements GenericResponse {

    private List<Request> requests;

    @Builder
    public GetUsersRequestResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, List<Request> requests) {
        super(httpStatus, status, responseCode, responseDescription);
        this.requests = requests;
    }
}
