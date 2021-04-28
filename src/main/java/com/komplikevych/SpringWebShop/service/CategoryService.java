package com.komplikevych.SpringWebShop.service;

import com.komplikevych.SpringWebShop.dto.CategoryDto;
import com.komplikevych.SpringWebShop.exception.category.CategoryAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.category.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CategoryService {

    Set<CategoryDto> getCategories();

    CategoryDto getCategory(Long id) throws CategoryNotFoundException;

    CategoryDto createCategory(CategoryDto categoryDto) throws CategoryAlreadyExistException;

    CategoryDto updateCategory(Long id, CategoryDto categoryDto) throws CategoryNotFoundException;

    void deleteCategory(Long id) throws CategoryNotFoundException;

}
