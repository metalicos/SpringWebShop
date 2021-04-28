package com.komplikevych.SpringWebShop.service.impl;

import com.komplikevych.SpringWebShop.dto.ShoppingCartDto;
import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.exception.shoppingcart.ShoppingCartAlreadyExistException;
import com.komplikevych.SpringWebShop.exception.shoppingcart.ShoppingCartNotFoundException;
import com.komplikevych.SpringWebShop.model.ShoppingCart;
import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.repository.ShoppingCartRepository;
import com.komplikevych.SpringWebShop.repository.UserRepository;
import com.komplikevych.SpringWebShop.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;

    @Override
    public ShoppingCartDto getShoppingCart(Long id) throws ShoppingCartNotFoundException {
        log.info("getting shopping cart from database by id {}", id);
        Optional<ShoppingCart> shoppingCart = Optional.ofNullable(shoppingCartRepository.findShoppingCartById(id)
                .orElseThrow(ShoppingCartNotFoundException::new));
        return mapShoppingCartToShoppingCartDto(shoppingCart.get());
    }

    @Override
    public ShoppingCartDto getShoppingCart(UserDto userDto) throws ShoppingCartNotFoundException {
        log.info("getting shopping cart from database by user {}", userDto);
        Optional<User> userByEmail = userRepository.findUserByEmail(userDto.getEmail());
        Optional<ShoppingCart> shoppingCart = Optional.ofNullable(shoppingCartRepository.findShoppingCartByUser(userByEmail.get())
                .orElseThrow(ShoppingCartNotFoundException::new));
        return mapShoppingCartToShoppingCartDto(shoppingCart.get());
    }

    @Override
    public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto) throws ShoppingCartAlreadyExistException {
        log.info("creating shopping cart of ShoppingCartDto {}", shoppingCartDto);
        ShoppingCart shoppingCart = mapShoppingCartDtoToShoppingCart(shoppingCartDto);
        shoppingCart = shoppingCartRepository.save(shoppingCart);
        return mapShoppingCartToShoppingCartDto(shoppingCart);
    }

    @Override
    public ShoppingCartDto updateShoppingCart(Long id, ShoppingCartDto shoppingCartDto) throws ShoppingCartNotFoundException {
        log.info("updating shopping cart in database: {}", shoppingCartDto);
        ShoppingCart shoppingCart = mapShoppingCartDtoToShoppingCart(shoppingCartDto);
        ShoppingCart shoppingCartFromDb = shoppingCartRepository.findShoppingCartById(id)
                .orElseThrow(ShoppingCartNotFoundException::new);
        shoppingCartRepository.delete(shoppingCartFromDb);
        shoppingCart = shoppingCartRepository.save(shoppingCart);
        return mapShoppingCartToShoppingCartDto(shoppingCart);
    }

    @Override
    public void deleteShoppingCart(Long id) throws ShoppingCartNotFoundException {
        log.info("deleting shopping cart in database by id {}", id);
        ShoppingCart shoppingCart= shoppingCartRepository.findShoppingCartById(id)
                .orElseThrow(ShoppingCartNotFoundException::new);
        shoppingCartRepository.delete(shoppingCart);
    }

    private ShoppingCartDto mapShoppingCartToShoppingCartDto(ShoppingCart shoppingCart) {
        return ShoppingCartDto.builder()
                .id(shoppingCart.getId())
                .user(shoppingCart.getUser())
                .shoppingCartHasProducts(shoppingCart.getShoppingCartHasProducts())
                .build();
    }

    private ShoppingCart mapShoppingCartDtoToShoppingCart(ShoppingCartDto shoppingCartDto) {
        return ShoppingCart.builder()
                .id(shoppingCartDto.getId())
                .user(shoppingCartDto.getUser())
                .shoppingCartHasProducts(shoppingCartDto.getShoppingCartHasProducts())
                .build();
    }
}
