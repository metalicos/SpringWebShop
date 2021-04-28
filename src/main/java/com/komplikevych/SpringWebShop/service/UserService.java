package com.komplikevych.SpringWebShop.service;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.exception.user.UserAlreadyExistsException;
import com.komplikevych.SpringWebShop.exception.user.UserNotFoundException;
import com.komplikevych.SpringWebShop.exception.user.UsersNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    Set<UserDto> getUsers() throws UsersNotFoundException;

    UserDto getUser(String email) throws UserNotFoundException;

    UserDto createUser(UserDto userDto) throws UserAlreadyExistsException;

    UserDto updateUser(String email, UserDto userDto) throws UserNotFoundException;

    void deleteUser(String email) throws UserNotFoundException;
}
