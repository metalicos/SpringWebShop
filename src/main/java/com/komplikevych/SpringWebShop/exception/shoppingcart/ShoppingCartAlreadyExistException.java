package com.komplikevych.SpringWebShop.exception.shoppingcart;

public class ShoppingCartAlreadyExistException extends Exception {
    public ShoppingCartAlreadyExistException() {
    }

    public ShoppingCartAlreadyExistException(String message) {
        super(message);
    }
}
