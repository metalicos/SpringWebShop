package com.komplikevych.SpringWebShop.service;

import com.komplikevych.SpringWebShop.dto.ProductDto;
import com.komplikevych.SpringWebShop.exception.product.ProductAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.product.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ProductService {

    Set<ProductDto> getProducts();

    ProductDto getProduct(Long id) throws ProductNotFoundException;

    ProductDto createProduct(ProductDto productDto) throws ProductAlreadyExistException;

    ProductDto updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException;

    void deleteProduct(Long id) throws ProductNotFoundException;
}
