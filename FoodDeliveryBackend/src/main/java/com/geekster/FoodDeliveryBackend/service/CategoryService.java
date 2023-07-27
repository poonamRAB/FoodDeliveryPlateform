package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.repository.IFoodCatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    IFoodCatRepo categoryRepo;
}
