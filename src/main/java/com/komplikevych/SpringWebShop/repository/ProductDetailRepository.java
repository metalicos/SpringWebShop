package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.Product;
import com.komplikevych.SpringWebShop.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    ProductDetail getProductDetailByProduct(Product product);

    void deleteProductDetailByProduct(Product product);

    boolean existsCategoryByProduct(Product product);
}
