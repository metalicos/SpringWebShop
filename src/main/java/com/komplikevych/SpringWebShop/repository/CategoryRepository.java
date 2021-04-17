package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getCategoryByName(String name);

    void deleteCategoryByName(String name);

    boolean existsCategoryByName(String name);
}
