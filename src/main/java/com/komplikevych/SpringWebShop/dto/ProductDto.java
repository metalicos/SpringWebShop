package com.komplikevych.SpringWebShop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.komplikevych.SpringWebShop.model.*;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    @NotNull(message = "Id cannot be NULL")
    private Long id;
    @NotNull(message = "Name cannot be NULL")
    private String name;
    @NotNull(message = "Price cannot be NULL")
    @Pattern(regexp = "^[-0-9]+.[0-9]+",message = "Price does not match pattern")
    private BigDecimal price;
    @NotNull(message = "Amount cannot be NULL")
    private Integer amount;
    private Integer orderedAmount;
    private List<ProductPhoto> productPhotos;
    private Category category;
    private ProductDetail productDetail;
    private Set<ShoppingCartHasProduct> shoppingCartHasProducts;
    private Set<UserOrderHasProduct> userOrderHasProducts;
}
