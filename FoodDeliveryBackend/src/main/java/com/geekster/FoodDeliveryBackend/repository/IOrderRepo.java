package com.geekster.FoodDeliveryBackend.repository;

import com.geekster.FoodDeliveryBackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Long> {
}
