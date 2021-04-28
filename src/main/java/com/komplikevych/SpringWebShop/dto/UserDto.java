package com.komplikevych.SpringWebShop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.komplikevych.SpringWebShop.model.ShoppingCart;
import com.komplikevych.SpringWebShop.model.UserOrder;
import com.komplikevych.SpringWebShop.model.enums.Role;
import com.komplikevych.SpringWebShop.model.enums.UserStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserDto {

    @NotNull(message = "Id cannot be NULL")
    private Long id;

    @NotNull(message = "Full Name cannot be NULL")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+( \\p{Lu}\\p{Ll}+)*$",message = "Full Name does not match the rules")
    private String fullName;

    @Email
    @NotNull(message = "Email cannot be NULL")
    @NotEmpty(message = "Your email, is empty")
    private String email;

    @NotNull(message = "Password cannot be NULL")
    @NotEmpty(message = "Your password, is empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$",
            message = "Password does not match the rules")
    private String password;

    @NotNull(message = "Repeat your password, field is NULL")
    @NotEmpty(message = "Repeat your password, field is empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,30}$",
            message = "Password does not match the rules")
    private String repeatPassword;

    private Role role;

    private UserStatus userStatus;

    private ShoppingCart shoppingCart;

    private Set<UserOrder> userOrders;
}
