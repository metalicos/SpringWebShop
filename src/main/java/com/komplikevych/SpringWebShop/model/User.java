package com.komplikevych.SpringWebShop.model;

import com.komplikevych.SpringWebShop.model.enums.Role;
import com.komplikevych.SpringWebShop.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500)
    private String fullName;

    @Column(nullable = false, unique = true, length = 300)
    private String email;

    @Column(nullable = false, length = 300)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus userStatus;

    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user")
    private Set<UserOrder> userOrders;
}
