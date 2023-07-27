package com.geekster.FoodDeliveryBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private Double price;

    @OneToOne
    @JoinColumn(name = "fk_item_cat_id")
    FoodCategory category;
}
