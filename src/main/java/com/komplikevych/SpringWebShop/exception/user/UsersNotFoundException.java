package com.komplikevych.SpringWebShop.exception.user;

public class UsersNotFoundException extends Exception{

    public UsersNotFoundException() {
    }

    public UsersNotFoundException(String message) {
        super(message);
    }
}
