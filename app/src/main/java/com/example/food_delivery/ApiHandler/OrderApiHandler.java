package com.example.food_delivery.ApiHandler;

import com.example.food_delivery.models.Order;
import com.example.food_delivery.models.OrderStatus;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface OrderApiHandler {
    @POST("/api/orders")
    Call<List<Order>> makeOrders(@Body List<Order> orders);

    @GET("/api/orders/{id}")
    Call<Order> getOrderById(@Path("id") String id);

    @GET("/api/users/{id}/orders/")
    Call<List<Order>> getOrdersByUserId(@Path("id") String userId);

    @GET("/api/order/status")
    Call<OrderStatus> getDeliveryStatus();
}
