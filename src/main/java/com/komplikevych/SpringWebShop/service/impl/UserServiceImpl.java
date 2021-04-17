package com.komplikevych.SpringWebShop.service.impl;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto getUser(String email) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }
}
