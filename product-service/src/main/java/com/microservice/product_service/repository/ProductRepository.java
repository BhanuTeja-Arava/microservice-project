package com.microservice.product_service.repository;

import com.microservice.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

  Optional<Product> findByNameAndDescriptionAndPrice(String name, String description, BigDecimal price);

}
