package com.komplikevych.SpringWebShop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
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
