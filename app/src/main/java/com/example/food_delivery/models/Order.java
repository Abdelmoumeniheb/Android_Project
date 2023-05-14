package com.example.food_delivery.models;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private Food food;
    private int quantity;

    public Order(Food food, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.food = food;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
