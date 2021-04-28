package com.komplikevych.SpringWebShop.service.impl;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.dto.UserOrderDto;
import com.komplikevych.SpringWebShop.exception.user.UserNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrderNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrdersNotFoundException;
import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.model.UserOrder;
import com.komplikevych.SpringWebShop.repository.UserOrderRepository;
import com.komplikevych.SpringWebShop.repository.UserRepository;
import com.komplikevych.SpringWebShop.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOrderServiceImpl implements UserOrderService {

    private final UserOrderRepository userOrderRepository;
    private final UserRepository userRepository;

    @Override
    public Set<UserOrderDto> getUserOrders(UserDto userDto) throws UserOrdersNotFoundException,
            UserNotFoundException {
        log.info("getting user orders from database by user {}", userDto);
        Optional<User> user = Optional.ofNullable(userRepository.findUserByEmail(userDto.getEmail())
                .orElseThrow(UserNotFoundException::new));
        Set<UserOrder> userOrders = userOrderRepository.findUserOrdersByUser(user.orElse(new User()));
        if (userOrders.isEmpty()) {
            throw new UserOrdersNotFoundException();
        }
        return userOrders.stream()
                .map(this::mapUserOrderToUserOrderDto)
                .collect(Collectors.toSet());
    }

    @Override
    public UserOrderDto getUserOrder(Long id) throws UserOrderNotFoundException {
        log.info("getting user order from database by id {}", id);
        Optional<UserOrder> userOrder = Optional.ofNullable(userOrderRepository.findUserOrderById(id)
                .orElseThrow(UserOrderNotFoundException::new));
        return mapUserOrderToUserOrderDto(userOrder.get());
    }

    @Override
    public UserOrderDto createUserOrder(UserOrderDto userOrderDto) {
        log.info("creating user order of UserOrderDto {}", userOrderDto);
        UserOrder userOrder = mapUserOrderDtoToUserOrder(userOrderDto);
        userOrder = userOrderRepository.save(userOrder);
        return mapUserOrderToUserOrderDto(userOrder);
    }

    @Override
    public UserOrderDto updateUserOrder(Long id, UserOrderDto userOrderDto) throws UserOrderNotFoundException {
        log.info("updating user order in database: {}", userOrderDto);
        UserOrder userOrder = mapUserOrderDtoToUserOrder(userOrderDto);
        UserOrder userOrderFromDb = userOrderRepository.findUserOrderById(id)
                .orElseThrow(UserOrderNotFoundException::new);
        userOrderRepository.delete(userOrderFromDb);
        userOrder = userOrderRepository.save(userOrder);
        return mapUserOrderToUserOrderDto(userOrder);
    }

    @Override
    public void deleteUserOrder(Long id) throws UserOrderNotFoundException {
        log.info("deleting user order in database by id {}", id);
        UserOrder user = userOrderRepository.findUserOrderById(id)
                .orElseThrow(UserOrderNotFoundException::new);
        userOrderRepository.delete(user);
    }

    private UserOrderDto mapUserOrderToUserOrderDto(UserOrder userOrder) {
        return UserOrderDto.builder()
                .id(userOrder.getId())
                .status(userOrder.getStatus())
                .user(userOrder.getUser())
                .totalOrderPrice(userOrder.getTotalOrderPrice())
                .userOrderHasProducts(userOrder.getUserOrderHasProducts())
                .build();
    }

    private UserOrder mapUserOrderDtoToUserOrder(UserOrderDto userOrderDto) {
        return UserOrder.builder()
                .id(userOrderDto.getId())
                .user(userOrderDto.getUser())
                .status(userOrderDto.getStatus())
                .totalOrderPrice(userOrderDto.getTotalOrderPrice())
                .userOrderHasProducts(userOrderDto.getUserOrderHasProducts())
                .build();
    }

}
