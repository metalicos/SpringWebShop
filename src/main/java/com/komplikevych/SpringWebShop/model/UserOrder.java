package com.komplikevych.SpringWebShop.model;

import com.komplikevych.SpringWebShop.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private BigDecimal totalOrderPrice;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "userOrder")
    private Set<UserOrderHasProduct> userOrderHasProducts;
}
