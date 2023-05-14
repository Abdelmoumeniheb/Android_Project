package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout Ordernow;
    ImageView notifications_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Ordernow = findViewById(R.id.Ordernow);
        Ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toOrderNow=new Intent(MenuActivity.this,OrderNow.class);
                startActivity(toOrderNow);
            }
        });
        notifications_icon = findViewById(R.id.notifications_icon);
        notifications_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toNotifications=new Intent(MenuActivity.this, MainActivity.class);
                startActivity(toNotifications);
            }
        });

    }
}