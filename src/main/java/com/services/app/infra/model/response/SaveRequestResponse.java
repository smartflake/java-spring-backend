package com.services.app.infra.model.response;

import com.services.app.infra.entity.Request;
import com.services.app.infra.model.GenericResponse;
import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SaveRequestResponse extends BaseResponse implements GenericResponse {

    private Request request;

    @Builder
    public SaveRequestResponse(HttpStatus httpStatus, String status, String responseCode, String responseDescription, Request request) {
        super(httpStatus, status, responseCode, responseDescription);
        this.request = request;
    }
}
