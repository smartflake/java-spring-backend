package com.services.app.util.response_builders;

import com.services.app.infra.model.response.BaseResponse;
import com.services.app.util.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */
@Component
public class BaseSuccess {
    public BaseResponse baseSuccessResponse(String description){
        var baseResponse = new BaseResponse();
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setResponseCode(String.valueOf(ResponseEnum.SUCCESS.getCode()));
        baseResponse.setStatus(ResponseEnum.SUCCESS.getMessage());
        baseResponse.setResponseDescription(description);
        return baseResponse;
    }
}
