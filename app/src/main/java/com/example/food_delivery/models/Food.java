package com.example.food_delivery.models;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String name;
    private String description;
    private String image;
    private double price;

    private String idrestaurant;

    public Food(int id, String name, String description, String image, double price, String idrestaurant) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.idrestaurant = idrestaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRestaurant() {
        return idrestaurant;
    }

    public void setRestaurant(String idrestaurant) {
        this.idrestaurant = idrestaurant;
    }
}
