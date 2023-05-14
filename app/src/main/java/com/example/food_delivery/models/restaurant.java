package com.example.food_delivery.models;

import java.io.Serializable;
import java.util.List;

public class restaurant implements Serializable {
    private String idrestaurant;
    private String name;
    private List<Food> menu;
    private List<String> Category;
    private String image;

    public restaurant(String idrestaurant, String name, List<Food> menu, List<String> Category, String image) {
        this.idrestaurant = idrestaurant;
        this.name = name;
        this.menu = menu;
        this.Category = Category;
        this.image = image;

    }

    public String getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(String idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getCategory() {
        return Category;
    }

    public void setCategory(List<String> category) {
        Category = category;
    }
    public String getStringCategory() {
        String category = "";
        for (int i = 0; i < Category.size(); i++) {
            category += Category.get(i);
            if (i != Category.size() - 1) {
                category += " - ";
            }
        }
        return category;
    }

    public String getId() {
        return idrestaurant;
    }

    public void setId(String idrestaurant) {
        this.idrestaurant = idrestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }


}
