package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.User;
import com.komplikevych.SpringWebShop.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

    List<UserOrder> getUserOrdersByUser(User user);

    void deleteUserOrdersByUser(User user);

    boolean existsUserOrdersByUser(User user);
}
