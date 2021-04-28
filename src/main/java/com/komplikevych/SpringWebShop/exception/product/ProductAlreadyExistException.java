package com.komplikevych.SpringWebShop.exception.product;

public class ProductAlreadyExistException extends Exception {
    public ProductAlreadyExistException() {
    }

    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
