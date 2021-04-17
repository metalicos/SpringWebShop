package com.komplikevych.SpringWebShop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Builder
@JsonInclude(Include.NON_NULL)
public class UserDto {
    private String firstName;
    private String lastName;
    @NotNull
    @Email
    private String email;
    private String password;
    private String repeatPassword;
}
