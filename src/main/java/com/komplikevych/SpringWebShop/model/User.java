package com.komplikevych.SpringWebShop.model;

import com.komplikevych.SpringWebShop.model.enums.Role;
import com.komplikevych.SpringWebShop.model.enums.UserStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AbstractEntity {

    @Column(nullable = false, unique = true, length = 300)
    private String email;

    @Column(nullable = false, length = 300)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user")
    private Set<UserOrder> userOrders;
}
