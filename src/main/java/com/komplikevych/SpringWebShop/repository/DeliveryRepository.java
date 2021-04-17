package com.komplikevych.SpringWebShop.repository;

import com.komplikevych.SpringWebShop.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
