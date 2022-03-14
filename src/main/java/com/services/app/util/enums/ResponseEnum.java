package com.services.app.util.enums;

/**
 * @author Ashwani Pandey
 * @created 20/02/2022
 */

public enum ResponseEnum {

    SUCCESS (200, "Success"),
    FAILURE(400,"Failure"),
    ADD_COMPANY_SUCCESS(200,"Company Added Successfully"),
    ADD_COMPANY_FAILURE(409,"Unable to add Company");


    private final int code;

    private final String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
