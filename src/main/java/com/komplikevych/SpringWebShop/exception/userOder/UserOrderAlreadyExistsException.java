package com.komplikevych.SpringWebShop.exception.userOder;

public class UserOrderAlreadyExistsException extends Exception{
    public UserOrderAlreadyExistsException() {
    }

    public UserOrderAlreadyExistsException(String message) {
        super(message);
    }
}
