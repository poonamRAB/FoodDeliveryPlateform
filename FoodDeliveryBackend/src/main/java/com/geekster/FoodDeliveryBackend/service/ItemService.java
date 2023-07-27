package com.geekster.FoodDeliveryBackend.service;

import com.geekster.FoodDeliveryBackend.model.Item;
import com.geekster.FoodDeliveryBackend.repository.IItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    IItemRepo itemRepo;

   
    public List<Item> foodItems() {
        return itemRepo.findAll();
    }

    public String addFoodItem(String email, Item item) {
        itemRepo.save(item);
        return "Item added successfully!!";
    }

    public String updateItem(String email, Long id, Item item) {
        item.setItemId(id);
        itemRepo.save(item);
        return "Item updated successfully!!";
    }

    public String deleteItem(String email, Long id) {
        itemRepo.deleteById(id);
        return "Item deleted successfully!!";
    }
}
