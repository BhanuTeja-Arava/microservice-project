package com.microservice.product_service.exception;

public class InvalidHttpRequests extends RuntimeException{
    public InvalidHttpRequests(String message) {
        super(message);
    }
}
