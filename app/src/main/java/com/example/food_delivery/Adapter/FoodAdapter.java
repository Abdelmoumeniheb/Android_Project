package com.example.food_delivery.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private Context context;
    private List<Food> foodList;

    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitem_food, parent, false);
        return new FoodViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.nameTextView.setText(food.getName());
        int resId = context.getResources().getIdentifier(food.getImage(), "drawable", context.getPackageName());
        holder.imageView.setImageResource(resId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodActivity.class);
                intent.putExtra("foodObject", food);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (foodList == null) {
            return 0;
        }
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private ImageView imageView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nom);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
