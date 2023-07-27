package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;
}
