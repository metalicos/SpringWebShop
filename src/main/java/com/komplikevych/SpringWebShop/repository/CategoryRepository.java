package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByName(String name);
    Optional<Category> findCategoryById(Long id);
    boolean existsCategoryById(Long id);
}
