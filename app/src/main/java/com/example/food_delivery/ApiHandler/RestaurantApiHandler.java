package com.example.food_delivery.ApiHandler;

import com.example.food_delivery.models.Food;
import com.example.food_delivery.models.restaurant;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;


import java.util.List;

public interface RestaurantApiHandler {
    @GET("/api/restaurants")
    Call<List<restaurant>> getAllRestaurants(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("/api/restaurants")
    Call<restaurant> addRestaurant(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email
    );

    @GET("/api/restaurants/{id}")
    Call<restaurant> getRestaurant(
            @Path("id") int id
    );

    @GET("/api/restaurants/{id}/foods")
    Call<List<Food>> getRestaurantFoods(
            @Path("id") int id
    );
}
