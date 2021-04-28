package com.komplikevych.SpringWebShop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.komplikevych.SpringWebShop.model.ShoppingCartHasProduct;
import com.komplikevych.SpringWebShop.model.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShoppingCartDto {
    @NotNull(message = "Id cannot be NULL")
    private Long id;
    @NotNull(message = "User cannot be NULL")
    private User user;
    private Set<ShoppingCartHasProduct> shoppingCartHasProducts;
}
