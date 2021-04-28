package com.komplikevych.SpringWebShop.exception.category;

public class CategoryAlreadyExistException extends Exception{
    public CategoryAlreadyExistException() {
    }

    public CategoryAlreadyExistException(String message) {
        super(message);
    }
}
