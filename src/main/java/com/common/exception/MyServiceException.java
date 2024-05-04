package com.common.exception;

public class MyServiceException extends RuntimeException{

    private String field;
    private Code code;

    MyServiceException( String field, Code code, String message, Throwable cause){
        super(message, cause);
        this.field = field;
        this.code = code;
    }

    public enum Code{
        GENERAL,
        BUSINESS,
        PERMISSION
    }
}
