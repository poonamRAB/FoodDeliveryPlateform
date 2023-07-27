package com.geekster.FoodDeliveryBackend.repository;

import com.geekster.FoodDeliveryBackend.model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodCartRepo extends JpaRepository<FoodCart,Long> {
}
