package com.example.food_delivery.Content;

import com.example.food_delivery.models.Food;
import com.example.food_delivery.models.restaurant;

import java.util.ArrayList;
import java.util.List;

public class restaurantContent {
    public static ArrayList<restaurant> getRestaurants() {
        ArrayList<restaurant> restaurants = new ArrayList<>();

        // Restaurant 1
        List<Food> menu1 = new ArrayList<>();
        menu1.add(new Food(1,"Couscous","bnina","@drawable/restaurant22", 10.5,    "1"));
        menu1.add(new Food(2,"Brik","bnina","@drawable/restaurant23", 3.5,    "1"));
        List<String> categories1 = new ArrayList<>();
        categories1.add("Tunisian");
        categories1.add("North African");
        restaurant restaurant1 = new restaurant("1", "Le Petit Tunisien", menu1, categories1, "@drawable/restaurant21");
        restaurants.add(restaurant1);

        // Restaurant 2
        List<Food> menu2 = new ArrayList<>();
        menu2.add(new Food(3,"Makroudh","bnina","@drawable/restaurant23", 2.0,    "2"));
        menu2.add(new Food(4,"Assida","bnina","@drawable/restaurant22", 4.5,    "2"));
        List<String> categories2 = new ArrayList<>();
        categories2.add("Tunisian");
        restaurant restaurant2 = new restaurant("2", "Dar Belhadj", menu2, categories2, "@drawable/restaurant22");
        restaurants.add(restaurant2);

        // Restaurant 3
        List<Food> menu3 = new ArrayList<>();
        menu3.add(new Food(5,"Brik","bnina","@drawable/restaurant23", 3.5,    "3"));
        menu3.add(new Food(6,"Couscous","bnina","@drawable/restaurant21", 120,    "3"));
        List<String> categories3 = new ArrayList<>();
        categories3.add("Tunisian");
        categories3.add("Mediterranean");
        restaurant restaurant3 = new restaurant("3", "La Closerie", menu3, categories3, "@drawable/restaurant23");
        restaurants.add(restaurant3);

        // Restaurant 4
        List<Food> menu4 = new ArrayList<>();
        menu4.add(new Food(7,"Ojja","bnina","@drawable/restaurant21", 8.0,    "4"));
        menu4.add(new Food(8,"Kafteji","bnina","@drawable/restaurant22", 3.5,    "4"));
        List<String> categories4 = new ArrayList<>();
        categories4.add("Tunisian");
        categories4.add("North African");
        restaurant restaurant4 = new restaurant("4", "Le Baroque", menu4, categories4, "@drawable/restaurant24");
        restaurants.add(restaurant4);

        // Restaurant 5
        List<Food> menu5 = new ArrayList<>();
        menu5.add(new Food(9,"Mloukhia","bnina","@drawable/restaurant21", 11.5,    "5"));
        menu5.add(new Food(11,"Kesra","bnina","@drawable/restaurant21", 2.5,    "5"));
        menu5.add(new Food(12,"Ma9rouna","bnina","@drawable/restaurant22", 4 ,   "5"));
        menu5.add(new Food(13,"Harissa","bnina","@drawable/restaurant23", 1.5,    "5"));
        List<String> categories5 = new ArrayList<>();
        categories5.add("Tunisian");
        restaurant restaurant5 = new restaurant("5", "El Ali", menu5, categories5, "@drawable/restaurant22");
        restaurants.add(restaurant5);

        // Restaurant 6
        List<Food> menu6 = new ArrayList<>();
        menu6.add(new Food(11,"Lablabi","bnin","@drawable/restaurant21", 4.0,    "6"));
        menu6.add(new Food(12,"Kemlia","bnin","@drawable/restaurant24", 2.5,    "6"));
        List<String> categories6 = new ArrayList<>();
        categories6.add("Tunisian");
        restaurant restaurant6 = new restaurant("6", "Chez Slah", menu6, categories6, "@drawable/restaurant23");
        restaurants.add(restaurant6);

        // Restaurant 7
        List<Food> menu7 = new ArrayList<>();
        menu7.add(new Food(14,"Chakchouka","bnina","@drawable/restaurant22", 8.5,"7"));
        menu7.add(new Food(13,"Brick","bnina","@drawable/restaurant24", 3.0,"7"));
        List<String> categories7 = new ArrayList<>();
        categories7.add("Tunisian");
        categories7.add("Mediterranean");
        restaurant restaurant7 = new restaurant("7", "Dar Slah", menu7, categories7, "@drawable/restaurant21");
        restaurants.add(restaurant7);

        // Restaurant 8
        List<Food> menu8 = new ArrayList<>();
        menu8.add(new Food(16,"Makroudh","bnina","@drawable/restaurant24", 2.5,"8"));
        menu8.add(new Food(15,"Assida","bnina","@drawable/restaurant23", 4.0,"8"));
        List<String> categories8 = new ArrayList<>();
        categories8.add("Tunisian");
        restaurant restaurant8 = new restaurant("8", "Le Bon Vieux Temps", menu8, categories8, "@drawable/restaurant24");
        restaurants.add(restaurant8);

        // Restaurant 9
        List<Food> menu9 = new ArrayList<>();
        menu9.add(new Food(17,"Chakchouka","bnina","@drawable/restaurant22", 8.0,"9"));
        menu9.add(new Food(18,"Mloukhia","bnina","@drawable/restaurant23", 11.0,"9"));
        List<String> categories9 = new ArrayList<>();
        categories9.add("Tunisian");
        categories9.add("North African");
        restaurant restaurant9 = new restaurant("9", "Le Menzel", menu9, categories9, "@drawable/restaurant22");
        restaurants.add(restaurant9);

        // Restaurant 10
        List<Food> menu10 = new ArrayList<>();
        menu10.add(new Food(20,"Couscous","bnina","@drawable/restaurant24", 10.0,"10"));
        menu10.add(new Food(19,"Brik","bnina","@drawable/restaurant21", 3.0,"10"));
        List<String> categories10 = new ArrayList<>();
        categories10.add("Tunisian");
        categories10.add("Mediterranean");
        restaurant restaurant10 = new restaurant("10", "Au Bon Vieux Temps", menu10, categories10, "@drawable/restaurant21");
        restaurants.add(restaurant10);

        return restaurants;
    }
    public static List<Food> getFoods(String restaurantName, List<restaurant> restaurantList) {
        for (int i = 0; i < restaurantList.size(); i++) {
            if (restaurantList.get(i).getName().equals(restaurantName)) {
                return restaurantList.get(i).getMenu();
            }
        }
        return null;
    }

    public restaurant getRestaurantById(String idrst, List<restaurant> restaurantList) {
        for (int i = 0; i < restaurantList.size(); i++) {
            if (restaurantList.get(i).getId().equals(idrst)) {
                return restaurantList.get(i);
            }
        }
        return null;
    }
}
