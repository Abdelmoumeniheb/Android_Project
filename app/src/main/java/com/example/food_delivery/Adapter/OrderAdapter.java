package com.example.food_delivery.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_delivery.FoodActivity;
import com.example.food_delivery.R;
import com.example.food_delivery.models.Food;
import com.example.food_delivery.models.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private Context context;
    private List<Order> OrderList;

    public OrderAdapter(Context context, List<Order> OrderList) {
        this.context = context;
        this.OrderList = OrderList;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitem_order, parent, false);
        return new OrderAdapter.OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = OrderList.get(position);
        holder.namefood.setText(order.getFood().getName());
        holder.quantity.setText(String.valueOf(order.getQuantity()));
        holder.price.setText(String.valueOf(order.getFood().getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    @Override
    public int getItemCount() {
        if (OrderList == null) {
            return 0;
        }
        return OrderList.size();
    }
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        private TextView quantity;
        private TextView namefood;
        private TextView price;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            quantity = itemView.findViewById(R.id.quantity);
            namefood = itemView.findViewById(R.id.namefood);
            price = itemView.findViewById(R.id.price);
        }
    }
}
