package com.geekster.FoodDeliveryBackend.repository;

import com.geekster.FoodDeliveryBackend.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepo extends JpaRepository<Restaurant,Long> {
}
