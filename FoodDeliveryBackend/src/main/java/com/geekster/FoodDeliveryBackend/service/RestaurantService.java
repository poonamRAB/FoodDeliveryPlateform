package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.repository.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepo restaurantRepo;
}
