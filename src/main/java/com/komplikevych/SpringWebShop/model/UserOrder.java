package com.komplikevych.SpringWebShop.model;

import com.komplikevych.SpringWebShop.model.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UserOrder extends AbstractEntity {

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private BigDecimal totalOrderPrice;
    private int deliveryId;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "userOrder")
    private Set<UserOrderHasProduct> userOrderHasProducts;
}
