package com.komplikevych.SpringWebShop.controller;

import com.komplikevych.SpringWebShop.dto.ProductDto;
import com.komplikevych.SpringWebShop.exception.product.ProductAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.product.ProductNotFoundException;
import com.komplikevych.SpringWebShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    Set<ProductDto> getProducts() {
        log.info("Product controller get products set");
        return productService.getProducts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    ProductDto getProduct(@PathVariable Long id) throws ProductNotFoundException {
        log.info("product controller get product by id = {}", id);
        return productService.getProduct(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProductDto createProduct(@Valid @RequestBody ProductDto productDto) throws ProductAlreadyExistException {
        log.info("product controller create product {}", productDto);
        return productService.createProduct(productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    ProductDto updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDto)
            throws ProductNotFoundException {
        log.info("product controller update product with id {} with {}", id, productDto);
        return productService.updateProduct(id, productDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        log.info("product controller delete product with id = {}", id);
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
