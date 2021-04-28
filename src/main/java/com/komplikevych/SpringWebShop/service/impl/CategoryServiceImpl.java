package com.komplikevych.SpringWebShop.service.impl;

import com.komplikevych.SpringWebShop.dto.CategoryDto;
import com.komplikevych.SpringWebShop.exception.category.CategoryAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.category.CategoryNotFoundException;
import com.komplikevych.SpringWebShop.model.Category;
import com.komplikevych.SpringWebShop.repository.CategoryRepository;
import com.komplikevych.SpringWebShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Set<CategoryDto> getCategories() {
        log.info("Get all categories from db");
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::mapCategoryToCategoryDto)
                .collect(Collectors.toSet());
    }

    @Override
    public CategoryDto getCategory(Long id) throws CategoryNotFoundException {
        log.info("get category with id = {}", id);
        Category category = categoryRepository.getOne(id);
        if (!categoryRepository.existsCategoryById(id)) {
            throw new CategoryNotFoundException();
        }
        return mapCategoryToCategoryDto(category);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) throws CategoryAlreadyExistException {
        log.info("create category {}", categoryDto);
        Optional<Category> optionalCategory = categoryRepository.findCategoryByName(categoryDto.getName());
        if (optionalCategory.isPresent()) {
          throw new CategoryAlreadyExistException();
        }
        Category category = mapCategoryDtoToCategory(categoryDto);
        category = categoryRepository.save(category);
        return  mapCategoryToCategoryDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) throws CategoryNotFoundException {
        log.info("update category by id {} with {}", id, categoryDto);
        Category category = mapCategoryDtoToCategory(categoryDto);
        Category categoryFromDb = categoryRepository.findCategoryById(id)
                .orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(categoryFromDb);
        category = categoryRepository.save(category);
        return mapCategoryToCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long id) throws CategoryNotFoundException {
        log.info("delete category from db with id {}", id);
        Category category = categoryRepository.findCategoryById(id).orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(category);
    }

    private CategoryDto mapCategoryToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .products(category.getProducts())
                .build();
    }

    private Category mapCategoryDtoToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .products(categoryDto.getProducts())
                .build();
    }

}
