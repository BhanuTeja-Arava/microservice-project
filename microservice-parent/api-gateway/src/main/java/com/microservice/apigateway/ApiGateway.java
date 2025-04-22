package com.microservice.apigateway;

import jakarta.ws.rs.core.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGateway {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateway.class,args);
        System.out.println("api gateway is running...");
    }
}
