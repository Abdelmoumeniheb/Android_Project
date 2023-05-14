package com.example.food_delivery.models;

import java.util.ArrayList;

public class OrderManager {
    private static OrderManager instance;
    private ArrayList<Order> orderList;

    private OrderManager() {
        orderList = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void clearOrderList() {
        orderList.clear();
    }
}

