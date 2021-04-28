package com.komplikevych.SpringWebShop.controller;

import com.komplikevych.SpringWebShop.dto.ShoppingCartDto;
import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.exception.shoppingcart.ShoppingCartAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.shoppingcart.ShoppingCartNotFoundException;
import com.komplikevych.SpringWebShop.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ShoppingCartDto getShoppingCart(@RequestBody UserDto userDto) throws ShoppingCartNotFoundException {
        log.info("ShoppingCart controller get ShoppingCart by user = {}", userDto);
        return shoppingCartService.getShoppingCart(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    ShoppingCartDto getShoppingCart(@PathVariable Long id) throws ShoppingCartNotFoundException {
        log.info("ShoppingCart controller get ShoppingCart by id = {}", id);
        return shoppingCartService.getShoppingCart(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ShoppingCartDto createShoppingCart(@Valid @RequestBody ShoppingCartDto shoppingCartDto)
            throws ShoppingCartAlreadyExistException {
        log.info("ShoppingCart controller create ShoppingCart {}", shoppingCartDto);
        return shoppingCartService.createShoppingCart(shoppingCartDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    ShoppingCartDto updateShoppingCart(@PathVariable Long id, @Valid @RequestBody ShoppingCartDto shoppingCartDto)
            throws ShoppingCartNotFoundException {
        log.info("ShoppingCart controller update ShoppingCart with id {} with {}", id, shoppingCartDto);
        return shoppingCartService.updateShoppingCart(id, shoppingCartDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteShoppingCart(@PathVariable Long id)
            throws ShoppingCartNotFoundException {
        log.info("ShoppingCart controller delete ShoppingCart with id = {}", id);
        shoppingCartService.deleteShoppingCart(id);
        return ResponseEntity.noContent().build();
    }
}
