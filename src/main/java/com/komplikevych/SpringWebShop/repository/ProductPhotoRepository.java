package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Long> {
}
