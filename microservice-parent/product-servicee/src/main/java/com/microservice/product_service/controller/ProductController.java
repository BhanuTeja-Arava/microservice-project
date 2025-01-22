package com.microservice.product_service.controller;

import com.microservice.product_service.dto.ProductRequest;
import com.microservice.product_service.dto.ProductResponse;
import com.microservice.product_service.model.Product;
import com.microservice.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //@PostMapping( consumes = {"application/json"})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return ResponseEntity.ok("Product created successfully");
    }

   // @GetMapping(produces = {"application/xml"})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){

        return productService.getAllProducts();
    }

}
