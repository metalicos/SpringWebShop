package com.komplikevych.SpringWebShop.service.impl;

import com.komplikevych.SpringWebShop.dto.ProductDto;
import com.komplikevych.SpringWebShop.exception.product.ProductAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.product.ProductNotFoundException;
import com.komplikevych.SpringWebShop.model.Product;
import com.komplikevych.SpringWebShop.repository.ProductRepository;
import com.komplikevych.SpringWebShop.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Set<ProductDto> getProducts() {
        log.info("Get all products from db");
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapProductToProductDto)
                .collect(Collectors.toSet());
    }

    @Override
    public ProductDto getProduct(Long id) throws ProductNotFoundException {
        log.info("get product with id = {}", id);
        Product product = productRepository.getOne(id);
        if (!productRepository.existsProductById(id)) {
            throw new ProductNotFoundException();
        }
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws ProductAlreadyExistException {
        log.info("create product {}", productDto);
        Optional<Product> optionalProduct = productRepository.findProductByName(productDto.getName());
        if (optionalProduct.isPresent()) {
            throw new ProductAlreadyExistException();
        }
        Product product = mapProductDtoToProduct(productDto);
        product = productRepository.save(product);
        return mapProductToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) throws ProductNotFoundException {
        log.info("update product by id {} with {}", id, productDto);
        Product product = mapProductDtoToProduct(productDto);
        Product productFromDb = productRepository.findProductById(id)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.delete(productFromDb);
        product = productRepository.save(product);
        return mapProductToProductDto(product);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        log.info("delete product from db with id {}", id);
        Product product = productRepository.findProductById(id)
                .orElseThrow(ProductNotFoundException::new);
        productRepository.delete(product);
    }

    private ProductDto mapProductToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .category(product.getCategory())
                .name(product.getName())
                .amount(product.getAmount())
                .orderedAmount(product.getOrderedAmount())
                .shoppingCartHasProducts(product.getShoppingCartHasProducts())
                .userOrderHasProducts(product.getUserOrderHasProducts())
                .build();
    }

    private Product mapProductDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .category(productDto.getCategory())
                .name(productDto.getName())
                .amount(productDto.getAmount())
                .orderedAmount(productDto.getOrderedAmount())
                .shoppingCartHasProducts(productDto.getShoppingCartHasProducts())
                .userOrderHasProducts(productDto.getUserOrderHasProducts())
                .build();
    }
}
