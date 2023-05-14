package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food_delivery.Adapter.FoodAdapter;

import com.example.food_delivery.Adapter.restaurantAdapter;
import com.example.food_delivery.Content.restaurantContent;
import com.example.food_delivery.models.Food;
import com.example.food_delivery.models.restaurant;

import java.util.List;

public class restaurantActivity extends AppCompatActivity {
    ImageView notifications_icon,imageView;
    RecyclerView recyclerViewfood;
    RecyclerView.LayoutManager layoutManager;
    TextView restaurantCategories,restaurantName;
    FoodAdapter Foodadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        restaurantCategories=(TextView)findViewById(R.id.restaurantCategoriesTextView);
        restaurantName=(TextView)findViewById(R.id.restaurantNameTextView);
        imageView=(ImageView)findViewById(R.id.imageView);
        Intent intent = getIntent();
        String categoriesTxt="",nameTxt="",ImageTxt="",idrst="";
        restaurant rst = (restaurant) getIntent().getSerializableExtra("restaurantObject");
        if (rst != null) {
            nameTxt = rst.getName();
            categoriesTxt = rst.getStringCategory();
            ImageTxt = rst.getImage();
        }
        else if(intent.hasExtra("idRestaurant")){
            idrst=intent.getStringExtra("idRestaurant");
            System.out.println("\n\n\"+idrst+\"\n\n");
            Log.d("restaurantActivity", "idrst: " + idrst);
            Log.d("restaurantActivity", "rst: " + rst);
            restaurantContent restaurantContent = new restaurantContent();
            restaurant rst2 = restaurantContent.getRestaurantById(idrst,restaurantContent.getRestaurants());
            if (rst2 != null) {
                nameTxt = rst2.getName();
                categoriesTxt = rst2.getStringCategory();
                ImageTxt = rst2.getImage();
            }
        }
            restaurantName.setText(nameTxt);
            restaurantCategories.setText(categoriesTxt);
            int resId = getResources().getIdentifier(ImageTxt, "drawable", getPackageName());
            imageView.setImageResource(resId);
        notifications_icon=(ImageView)findViewById(R.id.notifications_icon);
        notifications_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(restaurantActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        List<restaurant> listerestaurant = restaurantContent.getRestaurants();
        List<Food> listeFoods = restaurantContent.getFoods(nameTxt, listerestaurant);

        recyclerViewfood = findViewById(R.id.rcvfood);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewfood.setLayoutManager(layoutManager);
        Foodadapter = new FoodAdapter(this,listeFoods);
        recyclerViewfood.setAdapter(Foodadapter);
    }
}