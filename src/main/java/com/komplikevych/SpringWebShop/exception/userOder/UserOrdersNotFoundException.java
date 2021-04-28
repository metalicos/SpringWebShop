package com.komplikevych.SpringWebShop.exception.userOder;

public class UserOrdersNotFoundException extends Exception{

    public UserOrdersNotFoundException() {
    }

    public UserOrdersNotFoundException(String message) {
        super(message);
    }
}
