package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food_delivery.models.Food;
import com.example.food_delivery.models.Order;
import com.example.food_delivery.models.OrderManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    ImageView notifications_icon,imageView;
    TextView foodName,description_food,price_food;
    Button button1,button2,button3,btnconfirmer;
    private int quantity = 0;
    private List<Food> orderItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        foodName=findViewById(R.id.name_food);
        imageView=findViewById(R.id.imageView);
        description_food=findViewById(R.id.description_food);
        price_food=findViewById(R.id.price_food);
        btnconfirmer=findViewById(R.id.btnconfirmer);

        Intent intent = getIntent();
        String descriptionTxt="",nameTxt="",ImageTxt="",PriceTxt="";
        //Food food = intent.getParcelableExtra("all");
        Food food = (Food) getIntent().getSerializableExtra("foodObject");
        if (food != null) {
            descriptionTxt = food.getDescription();
            nameTxt = food.getName();
            ImageTxt = food.getImage();
            PriceTxt = String.valueOf(food.getPrice());
        }
        /*if(intent!=null) {
            if(intent.hasExtra("restaurantName")){
                nameTxt=intent.getStringExtra("restaurantName");
            }
            if(intent.hasExtra("restaurantCategory")){
                descriptionTxt=intent.getStringExtra("restaurantCategory");
            }
            if(intent.hasExtra("restaurantImage")){
                ImageTxt=intent.getStringExtra("restaurantImage");
            }if (intent.hasExtra("price_food")){
                PriceTxt=intent.getStringExtra("price_food");
            }
        }*/
            notifications_icon= findViewById(R.id.notifications_icon);
            notifications_icon.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(FoodActivity.this, restaurantActivity.class);
              intent.putExtra("idRestaurant", food.getRestaurant());
              Log.d("foodActivity", "idrst: " + food.getRestaurant());
              startActivity(intent);
                }
            });
            foodName.setText(nameTxt);
            description_food.setText(descriptionTxt);
            int resId = getResources().getIdentifier(ImageTxt, "drawable", getPackageName());
            imageView.setImageResource(resId);
            price_food.setText("$ "+PriceTxt);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity>0){
                    quantity--;
                    button2.setText(String.valueOf(quantity));
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                button2.setText(String.valueOf(quantity));
            }
        });
        btnconfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order = new Order(food, quantity);
                System.out.println("order: " + order.getQuantity()+'\n');

                /*SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
                String orderListJson = preferences.getString("orderList", null);
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<Order>>() {}.getType();
                ArrayList<Order> orderList = gson.fromJson(orderListJson, type);
                if (orderList == null) {
                    orderList = new ArrayList<>();
                }
                orderList.add(order);

                String updatedOrderListJson = gson.toJson(orderList);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("orderList", updatedOrderListJson);
                editor.apply();*/
                OrderManager orderManager = OrderManager.getInstance();
                orderManager.addOrder(order);
                Intent intent = new Intent(FoodActivity.this, restaurantActivity.class);
                intent.putExtra("idRestaurant", food.getRestaurant());
                startActivity(intent);
            }
        });

    }
}