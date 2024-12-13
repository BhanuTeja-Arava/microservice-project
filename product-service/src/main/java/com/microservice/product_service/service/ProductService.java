package com.microservice.product_service.service;


import com.microservice.product_service.dto.ProductRequest;
import com.microservice.product_service.dto.ProductResponse;
import com.microservice.product_service.model.Product;
import com.microservice.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.Builder;

import java.util.List;

@Service

@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {

//        Product product = Product.builder()
//                .name(productRequest.getName())
//                .description((productRequest.getDescription()))
//                .price(productRequest.getPrice())
//                .build();
//
//
//        productRepository.save(product);
//
//        log.info("Product {} is saved", product.getId());
    //log.info("checking....");
    }

    public String getAllProducts() {
        List<Product> products = productRepository.findAll();

  //      return products.stream().map(this::toProductResponse).toList();
        return "Checking..";
    }

//    private ProductResponse toProductResponse(Product product) {
//
//        return ProductResponse.builder()
//                .id(product.getId())
//                .name(product.getName())
//                .description(product.getDescription())
//                .price(product.getPrice())
//                .build();
//    }
}
