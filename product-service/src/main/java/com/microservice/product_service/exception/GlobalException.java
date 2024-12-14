package com.microservice.product_service.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(InvalidHttpRequests.class)
    public ResponseEntity<ErroMsg> handleInvalidHttpRequests(InvalidHttpRequests e) {
        ErroMsg erroMsg = new ErroMsg("Incorrect Http request","Please check the Http request");
        return new ResponseEntity<>(erroMsg, HttpStatusCode.valueOf(400));
    }

}
