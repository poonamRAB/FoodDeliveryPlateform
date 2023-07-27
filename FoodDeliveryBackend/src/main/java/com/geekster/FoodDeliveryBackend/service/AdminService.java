package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;
}
