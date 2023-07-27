package com.geekster.FoodDeliveryBackend.repository;

import com.geekster.FoodDeliveryBackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address,Long> {
}
