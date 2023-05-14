package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.food_delivery.Adapter.OrderAdapter;
import com.example.food_delivery.models.Order;
import com.example.food_delivery.models.OrderManager;

import java.util.ArrayList;

public class OrderNow extends AppCompatActivity {
    RecyclerView recyclerVieworder;
    RecyclerView.LayoutManager layoutManager;
    Button btnOrder;
    TextView totaltext;
    Double Total = 0.0;
    ArrayList<Order> orderList;
    ImageView notifications_icon;
    com.example.food_delivery.Adapter.OrderAdapter OrderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);
        recyclerVieworder = findViewById(R.id.rcvorder);
        btnOrder = findViewById(R.id.btnOrder);
        totaltext=findViewById(R.id.totaltext);
        layoutManager = new LinearLayoutManager(this);
        recyclerVieworder.setLayoutManager(layoutManager);
        //List<restaurant> listerestaurant = restaurantContent.getRestaurants();

        /*SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        String orderListJson = preferences.getString("orderList", null);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Order>>() {}.getType();
        orderList = gson.fromJson(orderListJson, type);
        if (orderList == null) {
            orderList = new ArrayList<>();
        }

        System.out.println("Order List: " + orderList.size());*/
        OrderManager orderManager = OrderManager.getInstance();
        ArrayList<Order> orderList = orderManager.getOrderList();
        for (Integer i = 0; i < orderList.size(); i++) {
            Total=Total + orderList.get(i).getFood().getPrice()*orderList.get(i).getQuantity();
        }
        totaltext.setText(String.valueOf(Total));

        OrderAdapter = new OrderAdapter(this,orderList);
        recyclerVieworder.setAdapter(OrderAdapter);
        /*btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderNow.this, CheckIn.class);
                startActivity(intent);
            }
        });
    }
}