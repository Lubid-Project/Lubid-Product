package com.lubid.product.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT c FROM Product c WHERE c.productId = :productId")
    Optional<Product> findByProductId(Long productId);
}
