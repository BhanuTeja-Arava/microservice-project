package com.microservice.product_service.configuration;

import com.microservice.product_service.controller.CustomRequestInceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    CustomRequestInceptor customRequestInceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(customRequestInceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/v1/product");
    }
}
