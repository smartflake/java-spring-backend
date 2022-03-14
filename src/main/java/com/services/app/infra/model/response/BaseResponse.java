package com.services.app.infra.model.response;

import com.services.app.util.constants.JsonConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse implements Serializable {

    @JsonIgnore
    private HttpStatus httpStatus;

    @JsonProperty(JsonConstants.BASE_RESPONSE_STATUS)
    private String status;

    @JsonProperty(JsonConstants.BASE_RESPONSE_CODE)
    private String responseCode;

    @JsonProperty(JsonConstants.BASE_RESPONSE_DESCRIPTION)
    private String responseDescription;



}
