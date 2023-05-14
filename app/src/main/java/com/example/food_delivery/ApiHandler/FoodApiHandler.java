package com.example.food_delivery.ApiHandler;

import com.example.food_delivery.models.Food;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface FoodApiHandler {
    @GET("/api/foods")
    Call<List<Food>> getAllFoods();

    @GET("/api/foods/{id}")
    Call<Food> getFoodById(@Path("id") int id);
    @GET("/api/restaurants/{id}/foods")
    Call<Food> getFoodByRestaurants(@Path("id") int id);
}

