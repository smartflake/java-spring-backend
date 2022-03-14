package com.services.app.util.response_builders;

import com.services.app.infra.model.response.BaseResponse;
import com.services.app.util.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Ashwani Pandey
 * @created 21/02/2022
 */
@Component
public class BaseFailure {

    public BaseResponse baseFailResponse(String description){
        var baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        baseResponse.setResponseCode(String.valueOf(ResponseEnum.FAILURE.getCode()));
        baseResponse.setStatus(ResponseEnum.FAILURE.getMessage());
        baseResponse.setResponseDescription(description);
        return baseResponse;
    }
}
