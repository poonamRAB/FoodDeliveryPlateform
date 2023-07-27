package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.repository.IFoodCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    IFoodCartRepo cartRepo;
}
