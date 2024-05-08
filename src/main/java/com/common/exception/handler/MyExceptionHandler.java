package com.common.exception.handler;

import com.common.exception.MessageResponse;
import com.common.exception.MyServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        // Log the exception
        logger.error("Error : ", ex);

        // Customize the response
        MessageResponse errorResponse = new MessageResponse(null, MyServiceException.Code.GENERAL, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MyServiceException.class)
    public ResponseEntity<Object> handleMyException(MyServiceException ex, WebRequest request) {
        // Log the exception
        logger.error("Error : ", ex);

        // Customize the response
        MessageResponse errorResponse = new MessageResponse(null, MyServiceException.Code.GENERAL, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
