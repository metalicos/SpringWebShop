package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.exception.userOder.UserOrderNotFoundException;
import com.komplikevych.SpringWebShop.exception.userOder.UserOrdersNotFoundException;
import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
    Set<UserOrder> findUserOrdersByUser(User user) throws UserOrdersNotFoundException;
    Optional<UserOrder> findUserOrderById(Long id) throws UserOrderNotFoundException;
    void deleteUserOrderById(Long id) throws UserOrderNotFoundException;
    boolean existsUserOrderById(Long id);
}
