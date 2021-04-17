package com.komplikevych.SpringWebShop.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
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

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

}
