package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Delivery extends AbstractEntity {
    private String name;
    private String averageDeliveryTime;
    private BigDecimal deliveryPrice;
}
