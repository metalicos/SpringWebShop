package com.komplikevych.SpringWebShop.service.impl;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.exception.user.UserAlreadyExistsException;
import com.komplikevych.SpringWebShop.exception.user.UserNotFoundException;
import com.komplikevych.SpringWebShop.exception.user.UsersNotFoundException;
import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.repository.UserRepository;
import com.komplikevych.SpringWebShop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Set<UserDto> getUsers() throws UsersNotFoundException {
        log.info("getting users from database");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toSet());
    }

    @Override
    public UserDto getUser(String email) throws UserNotFoundException {
        log.info("getting user from database by email {}", email);
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) throws UserAlreadyExistsException {
        log.info("creating user of UserDto {}", userDto);
        User user = mapUserDtoToUser(userDto);
        if (!userRepository.existsUserByEmail(user.getEmail())) {
            user = userRepository.save(user);
            return mapUserToUserDto(user);
        }
        throw new UserAlreadyExistsException();
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) throws UserNotFoundException {
        log.info("updating user in database: {}", userDto);
        User user = mapUserDtoToUser(userDto);
        User userFromDB = userRepository.findUserByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(userFromDB);
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) throws UserNotFoundException {
        log.info("deleting user in database by email {}", email);
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }


    public UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .userOrders(user.getUserOrders())
                .userStatus(user.getUserStatus())
                .role(user.getRole())
                .build();
    }

    public User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .fullName(userDto.getFullName())
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .userOrders(userDto.getUserOrders())
                .userStatus(userDto.getUserStatus())
                .role(userDto.getRole())
                .build();
    }
}
