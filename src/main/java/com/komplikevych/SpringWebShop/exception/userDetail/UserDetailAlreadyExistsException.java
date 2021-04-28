package com.komplikevych.SpringWebShop.exception.userDetail;

public class UserDetailAlreadyExistsException extends Exception{
    public UserDetailAlreadyExistsException() {
    }

    public UserDetailAlreadyExistsException(String message) {
        super(message);
    }
}
