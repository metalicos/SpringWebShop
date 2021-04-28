package com.komplikevych.SpringWebShop.service;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.dto.UserOrderDto;
import com.komplikevych.SpringWebShop.exception.user.UserNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrderAlreadyExistsException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrderNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrdersNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserOrderService {

    Set<UserOrderDto> getUserOrders(UserDto userDto) throws UserOrdersNotFoundException, UserNotFoundException;

    UserOrderDto getUserOrder(Long id) throws UserOrderNotFoundException;

    UserOrderDto createUserOrder(UserOrderDto userOrderDto) throws UserOrderAlreadyExistsException;

    UserOrderDto updateUserOrder(Long id, UserOrderDto userOrderDto) throws UserOrderNotFoundException;

    void deleteUserOrder(Long id) throws UserOrderNotFoundException;
}
