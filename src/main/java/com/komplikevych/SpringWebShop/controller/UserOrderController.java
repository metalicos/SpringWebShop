package com.komplikevych.SpringWebShop.controller;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.dto.UserOrderDto;
import com.komplikevych.SpringWebShop.exception.user.UserNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrderAlreadyExistsException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrderNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrdersNotFoundException;
import com.komplikevych.SpringWebShop.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class UserOrderController {

    private final UserOrderService userOrderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Set<UserOrderDto> getUserOrders(@RequestBody UserDto userDto)
            throws UserOrdersNotFoundException, UserNotFoundException {
        log.info("Get user {} orders: ", userDto);
        return userOrderService.getUserOrders(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public UserOrderDto getUserOrder(@PathVariable Long id)
            throws UserOrderNotFoundException {
        log.info("Get user orders with id: {}", id);
        return userOrderService.getUserOrder(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserOrderDto createUser(@RequestBody UserOrderDto userOrderDto)
            throws UserOrderAlreadyExistsException {
        log.info("Create user order: {}", userOrderDto);
        return userOrderService.createUserOrder(userOrderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public UserOrderDto updateUser(@PathVariable Long id, @RequestBody UserOrderDto userOrderDto)
            throws UserOrderNotFoundException {
        log.info("Update user order: {}", userOrderDto);
        return userOrderService.updateUserOrder(id, userOrderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id)
            throws UserOrderNotFoundException {
        log.info("Delete user order with id: {}", id);
        userOrderService.deleteUserOrder(id);
        return ResponseEntity.noContent().build();
    }

}
