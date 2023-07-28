package com.geekster.FoodDeliveryBackend.controller;

import com.geekster.FoodDeliveryBackend.model.Item;
import com.geekster.FoodDeliveryBackend.model.Order;
import com.geekster.FoodDeliveryBackend.model.Restaurant;
import com.geekster.FoodDeliveryBackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @Autowired
    AuthenticationService authService;

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/item")
    public String addFoodItem(@PathVariable String email, @RequestBody Item item,@RequestParam String token){
        if(authService.authenticate(email,token)){
            return itemService.addFoodItem(email,item);
        }
        else{
            return "Not an authenticated user!!";
        }
    }

    //get item list
    @GetMapping("/item")
    public List<Item> foodItems(){
        return itemService.foodItems();
    }

    //update item by id
    @PutMapping("/item/{id}")
    public String updateItem(@PathVariable String email, @PathVariable Long id,@RequestBody Item item,@PathVariable String token){
        if(authService.authenticate(email,token)){
            return itemService.updateItem(email,id,item);
        }
        else{
            return "Not an authenticated user!!";
        }
    }

    //delete item by id
    @DeleteMapping("/item/{id}")
    public String deleteItem(@PathVariable String email, @PathVariable Long id,@PathVariable String token){
        if(authService.authenticate(email,token)){
            return itemService.deleteItem(email,id);
        }
        else{
            return "non authenticated user found!!";
        }
    }

    //get order list
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    //add restaurant
    @PostMapping("/restaurant")
    public String addRestaurant(@PathVariable String email, @RequestBody Restaurant restaurant, @RequestParam String token){
        if(authService.authenticate(email,token)){
            return restaurantService.addRestaurant(email,restaurant);
        }
        else{
            return "non authenticated user found!!";
        }
    }

    

    //Delete restaurant
    @DeleteMapping("/restaurant/{id}")
    public String deleteRestaurant(@PathVariable String email, @PathVariable Long id,@PathVariable String token){
        if(authService.authenticate(email,token)){
            return restaurantService.deleteRestaurant(email,id);
        }
        else{
            return "non authenticated user found!!";
        }
    }
}
