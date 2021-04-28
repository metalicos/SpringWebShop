package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.ShoppingCart;
import com.komplikevych.SpringWebShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    Optional<ShoppingCart> findShoppingCartByUser(User user);
    Optional<ShoppingCart> findShoppingCartById(Long id);
    boolean existsShoppingCartById(Long id);
}
