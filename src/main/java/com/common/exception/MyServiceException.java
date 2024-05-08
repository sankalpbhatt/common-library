package com.common.exception;

import java.util.List;

public class MyServiceException extends RuntimeException{

    private final List<MessageResponse> response;

    public MyServiceException(String field, Code code, String message, Throwable cause, String errorCode){
        super(message, cause);
        this.response = List.of( new MessageResponse(field, code, message, null, errorCode) );
    }

    public MyServiceException(String field, Code code, String message, Throwable cause){
        super(message, cause);
        this.response = List.of( new MessageResponse(field, code, message, null, null) );
    }

    public enum Code{
        GENERAL,
        BUSINESS,
        PERMISSION
    }
}
