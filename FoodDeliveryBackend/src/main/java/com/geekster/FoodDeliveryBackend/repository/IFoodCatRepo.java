package com.geekster.FoodDeliveryBackend.repository;

import com.geekster.FoodDeliveryBackend.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodCatRepo extends JpaRepository<FoodCategory,Long> {
}
