package com.komplikevych.SpringWebShop.exception.userOder;

public class UserOrderNotFoundException extends Exception{

    public UserOrderNotFoundException() {
    }

    public UserOrderNotFoundException(String message) {
        super(message);
    }
}
