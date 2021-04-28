package com.komplikevych.SpringWebShop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.model.UserOrderHasProduct;
import com.komplikevych.SpringWebShop.model.enums.Status;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOrderDto {

    @NotNull(message = "Id cannot be NULL")
    private Long id;

    @NotNull(message = "Status cannot be NULL")
    private Status status;

    @NotNull(message = "Total Order Price cannot be NULL")
    private BigDecimal totalOrderPrice;

    private User user;

    private Set<UserOrderHasProduct> userOrderHasProducts;
}
