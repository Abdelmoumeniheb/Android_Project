package com.example.food_delivery.Adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_delivery.R;
import com.example.food_delivery.models.restaurant;
import com.example.food_delivery.restaurantActivity;

import java.util.List;

public class restaurantAdapter extends RecyclerView.Adapter<restaurantAdapter.restaurantViewHolder>
{
    public Context context;
    public List<restaurant> listerestaurant;

    public restaurantAdapter(Context context, List<restaurant> listerestaurant) {
        this.context = context;
        this.listerestaurant = listerestaurant;
    }

    @NonNull
    @Override
    public restaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitem_restaurant,parent,false);
        restaurantViewHolder etudaintViewHolder = new restaurantViewHolder(view);
        return etudaintViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull restaurantViewHolder holder,@SuppressLint("RecyclerView") int position) {
        restaurant restaurant = listerestaurant.get(position);
        holder.Name.setText(restaurant.getName());
        holder.Category.setText(restaurant.getStringCategory());
        int resId = context.getResources().getIdentifier(restaurant.getImage(), "drawable", context.getPackageName());
        holder.Image.setImageResource(resId);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, restaurantActivity.class);
                intent.putExtra("restaurantObject", restaurant);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listerestaurant.size();
    }

    public static class restaurantViewHolder extends RecyclerView.ViewHolder{

        TextView Name;
        TextView Category;
        ImageView Image;
        public restaurantViewHolder(@NonNull View itemView){
            super(itemView);
            Name=itemView.findViewById(R.id.nom);
            Category = itemView.findViewById(R.id.categories);
            Image = itemView.findViewById(R.id.image);
        }
    }
}
