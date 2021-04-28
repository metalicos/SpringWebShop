package com.komplikevych.SpringWebShop.exception.shoppingcart;

public class ShoppingCartNotFoundException extends Exception{
    public ShoppingCartNotFoundException() {
    }

    public ShoppingCartNotFoundException(String message) {
        super(message);
    }
}
