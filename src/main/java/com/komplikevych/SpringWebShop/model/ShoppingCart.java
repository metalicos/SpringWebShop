package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ShoppingCart extends AbstractEntity {

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "shoppingCart")
    private Set<ShoppingCartHasProduct> shoppingCartHasProducts;

}
