package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductByName(String name);

    void deleteProductByName(String name);

    boolean existsByName(String name);
}
