package com.microservice.product_service.service;


import com.microservice.product_service.dto.ProductRequest;
import com.microservice.product_service.dto.ProductResponse;
import com.microservice.product_service.model.Product;
import com.microservice.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private String existingProductId;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public void createProduct(ProductRequest productRequest) {
        // using model mapper to convert product request to product
        Product convertedProductObject = modelMapper.map(productRequest, Product.class);
        Optional<Product> existingProduct = productRepository.findByNameAndDescriptionAndPrice(convertedProductObject.getName(), convertedProductObject.getDescription(), convertedProductObject.getPrice());

        existingProduct.ifPresent(product -> {
            if(product.getId()!=null){
                this.existingProductId = product.getId();
            }
        });

        if(existingProduct.isPresent()){

            Product product = existingProduct.get();
            product.setQuantity(product.getQuantity()+1);
            productRepository.save(product);

        }
        else {
            convertedProductObject.setQuantity(1);
            productRepository.save(convertedProductObject);
        }
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        //      return products.stream().map(this::toProductResponse).toList();
        List<ProductResponse> collect = products.stream().map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());

        System.out.println(collect);
        return collect;

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
