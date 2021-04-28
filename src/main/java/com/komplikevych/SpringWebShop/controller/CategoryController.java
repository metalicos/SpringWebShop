package com.komplikevych.SpringWebShop.controller;

import com.komplikevych.SpringWebShop.dto.CategoryDto;
import com.komplikevych.SpringWebShop.exception.category.CategoryAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.category.CategoryNotFoundException;
import com.komplikevych.SpringWebShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Set<CategoryDto> getCategories() {
        log.info("Category controller get categories set");
        return categoryService.getCategories();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    CategoryDto getCategory(@PathVariable Long id) throws CategoryNotFoundException {
        log.info("category controller get category by id = {}", id);
        return categoryService.getCategory(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CategoryDto createCategory(@Valid @RequestBody CategoryDto categoryDto) throws CategoryAlreadyExistException {
        log.info("category controller create category {}", categoryDto);
        return categoryService.createCategory(categoryDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    CategoryDto updateCategory(@PathVariable Long id,@Valid @RequestBody CategoryDto categoryDto) throws CategoryNotFoundException {
        log.info("category controller update category with id {} with {}", id, categoryDto);
        return categoryService.updateCategory(id,categoryDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteCategory(@PathVariable Long id) throws CategoryNotFoundException {
        log.info("category controller delete category with id = {}",id);
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
