package com.microservice.product_service.controller;

import com.microservice.product_service.exception.InvalidHttpRequests;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CustomRequestInceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // System.out.println("Pre Handle is Invoked");
        String requestUrl = request.getRequestURI();

        if (!"/api/v1/product".equals(requestUrl)) {
            throw new InvalidHttpRequests(  requestUrl);
        }


        return true;
    }
}
