package com.komplikevych.SpringWebShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCartHasProduct implements Serializable {

    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private ShoppingCart shoppingCart;

    private Integer productAmount;

}
