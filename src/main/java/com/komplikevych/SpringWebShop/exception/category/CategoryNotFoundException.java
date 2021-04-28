package com.komplikevych.SpringWebShop.exception.category;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
