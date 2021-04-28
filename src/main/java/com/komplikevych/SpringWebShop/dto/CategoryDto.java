package com.komplikevych.SpringWebShop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.komplikevych.SpringWebShop.model.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
    @NotNull(message = "Id cannot be NULL")
    private Long id;
    @NotNull(message = "Name cannot be NULL")
    private String name;
    private String description;
    private List<Product> products;
}
