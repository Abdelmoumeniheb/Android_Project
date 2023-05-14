package com.example.food_delivery.ApiHandler;

import com.example.food_delivery.models.User;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface UserApiHandler {
    @POST("/api/login")
    Call <Boolean> login(
            @Field("username") String username,
            @Field("password") String password
    );
    @FormUrlEncoded
    @POST("/api/register")
    Call <User> registerUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String emails
    );

}