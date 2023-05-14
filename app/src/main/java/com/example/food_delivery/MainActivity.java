package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.food_delivery.Fragements_Home.BasicFragment;
import com.example.food_delivery.Fragements_Home.Loading_Screen;
import com.example.food_delivery.models.Order;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Loading_Screen Loading_Screen = new Loading_Screen();
        BasicFragment BasicFragment = new BasicFragment();
        fragmentTransaction.add(R.id.fragment_container,  Loading_Screen);
        fragmentTransaction.commit();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, BasicFragment);
                transaction.commit();
            }
        }, 500);

        ArrayList<Order> orderList = new ArrayList<>();
        Gson gson = new Gson();
        String orderListJson = gson.toJson(orderList);
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        editor.putString("orderList", orderListJson);
        editor.apply();

    }
}