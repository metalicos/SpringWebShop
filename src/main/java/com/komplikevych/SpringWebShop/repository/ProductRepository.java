package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String name);
    Optional<Product> findProductById(Long id);
    boolean existsProductById(Long id);
}
