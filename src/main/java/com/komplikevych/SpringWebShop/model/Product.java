package com.komplikevych.SpringWebShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
