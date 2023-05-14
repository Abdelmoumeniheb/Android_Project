package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.food_delivery.Adapter.restaurantAdapter;
import com.example.food_delivery.Content.restaurantContent;
import com.example.food_delivery.models.restaurant;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerViewrestaurant;
    RecyclerView.LayoutManager layoutManager;
    ImageView notifications_icon;
    restaurantAdapter restaurantAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        notifications_icon= findViewById(R.id.notifications_icon);
        notifications_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerViewrestaurant = findViewById(R.id.rcvrst);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewrestaurant.setLayoutManager(layoutManager);
        List<restaurant> listerestaurant = restaurantContent.getRestaurants();
        restaurantAdapter = new restaurantAdapter(this,listerestaurant);
        recyclerViewrestaurant.setAdapter(restaurantAdapter);
    }
}