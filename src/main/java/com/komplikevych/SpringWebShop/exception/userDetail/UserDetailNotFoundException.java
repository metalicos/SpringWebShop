package com.komplikevych.SpringWebShop.exception.userDetail;

public class UserDetailNotFoundException extends Exception{
    public UserDetailNotFoundException() {
    }

    public UserDetailNotFoundException(String message) {
        super(message);
    }
}
