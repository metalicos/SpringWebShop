package com.komplikevych.SpringWebShop.service;

import com.komplikevych.SpringWebShop.dto.UserDto;

public interface UserService {
    UserDto getUser(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);
}
