package com.common.exception;

import java.util.List;

public class MyServiceException extends RuntimeException{

    private final List<MessageResponse> response;

    public MyServiceException(String field, Code code, String errorCode, String message, Throwable cause){
        super(message, cause);
        this.response = List.of( new MessageResponse(field, code, message, null, errorCode) );
    }

    public enum Code{
        GENERAL,
        BUSINESS,
        PERMISSION
    }
}
