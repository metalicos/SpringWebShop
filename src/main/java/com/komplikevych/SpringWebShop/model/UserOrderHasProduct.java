package com.komplikevych.SpringWebShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserOrderHasProduct implements Serializable {

    @Id
    @ManyToOne
    private UserOrder userOrder;

    @Id
    @ManyToOne
    private Product product;

    private Integer productAmount;

    private BigDecimal price;
}
