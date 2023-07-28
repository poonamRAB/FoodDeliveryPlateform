package com.geekster.FoodDeliveryBackend.model;

import com.geekster.FoodDeliveryBackend.model.enums.DeliveryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderTime;
    @Enumerated(EnumType.STRING)
    private DeliveryType type;
    private String orderStatus;

    @ManyToOne
    Customer customer;

    @OneToOne
    FoodCart cart;
}
