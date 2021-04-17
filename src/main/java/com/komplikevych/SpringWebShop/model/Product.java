package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Product extends AbstractEntity {

    private String name;
    private BigDecimal price;
    private Integer amount;
    private Integer orderedAmount;

    /* Images as base64 */
    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> productPhotos;

    @ManyToOne
    private Category category;

    @OneToOne(mappedBy = "product")
    private ProductDetail productDetail;

    @OneToMany(mappedBy = "product")
    private Set<ShoppingCartHasProduct> shoppingCartHasProducts;

    @OneToMany(mappedBy = "product")
    private Set<UserOrderHasProduct> userOrderHasProducts;
}
