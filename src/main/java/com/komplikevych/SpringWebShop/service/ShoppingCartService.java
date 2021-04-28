package com.komplikevych.SpringWebShop.service;

import com.komplikevych.SpringWebShop.dto.ShoppingCartDto;
import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.exception.shoppingcart.ShoppingCartAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.shoppingcart.ShoppingCartNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    ShoppingCartDto getShoppingCart(Long id) throws ShoppingCartNotFoundException;

    ShoppingCartDto getShoppingCart(UserDto userDto) throws ShoppingCartNotFoundException;

    ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto) throws ShoppingCartAlreadyExistException;

    ShoppingCartDto updateShoppingCart(Long id, ShoppingCartDto shoppingCartDto) throws ShoppingCartNotFoundException;

    void deleteShoppingCart(Long id) throws ShoppingCartNotFoundException;
}
