package com.geekster.FoodDeliveryBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String restaurantName;
    private String contactNumber;
    private String managerName;

    @OneToOne
    @JoinColumn(name = "fk_address_id")
    Address address;

    @OneToMany
    private List<Item> items;
}
