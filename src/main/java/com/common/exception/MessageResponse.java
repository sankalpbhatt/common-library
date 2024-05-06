package com.common.exception;

public class MessageResponse {

    private final String field;
    private final MyServiceException.Code code;
    private final String message;
    private String source;
    private final String errorCode;

    public MessageResponse(String field, MyServiceException.Code code, String message, String source, String errorCode) {
        this.field = field;
        this.code = code;
        this.message = message;
        this.source = source;
        this.errorCode = errorCode;
    }

    public MessageResponse(String field, MyServiceException.Code code, String message) {
        this(field, code, message, null, null);
    }

    public String getField() {
        return field;
    }

    public MyServiceException.Code getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
