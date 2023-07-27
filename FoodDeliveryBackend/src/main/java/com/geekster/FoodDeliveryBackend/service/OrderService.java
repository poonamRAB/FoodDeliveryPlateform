package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.model.Order;
import com.geekster.FoodDeliveryBackend.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
