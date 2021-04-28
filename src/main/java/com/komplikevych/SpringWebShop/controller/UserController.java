package com.komplikevych.SpringWebShop.controller;

import com.komplikevych.SpringWebShop.dto.UserDto;
import com.komplikevych.SpringWebShop.exception.user.UserAlreadyExistsException;
import com.komplikevych.SpringWebShop.exception.user.UserNotFoundException;
import com.komplikevych.SpringWebShop.exception.user.UsersNotFoundException;
import com.komplikevych.SpringWebShop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Set<UserDto> getUsers() throws UsersNotFoundException {
        return userService.getUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDto getUser(@PathVariable String email)
            throws UserNotFoundException {
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto)
            throws UserAlreadyExistsException {
        log.info("Create user: {}", userDto);
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto)
            throws UserNotFoundException {
        return userService.updateUser(email, userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email)
            throws UserNotFoundException {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
