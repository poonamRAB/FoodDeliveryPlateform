package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.model.Restaurant;
import com.geekster.FoodDeliveryBackend.repository.IRestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepo restaurantRepo;


    public String addRestaurant(String email, Restaurant restaurant) {
        restaurantRepo.save(restaurant);
        return "New restaurant added successfully!!";
    }


    public String deleteRestaurant(String email, Long id) {
        restaurantRepo.deleteById(id);
        return "Restaurant for :"+id+" deleted successfully!!";
    }

}
