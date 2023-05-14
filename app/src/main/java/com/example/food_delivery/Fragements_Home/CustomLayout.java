package com.example.food_delivery.Fragements_Home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.food_delivery.R;

public class CustomLayout extends LinearLayout {
    private ImageView imageView;
    private TextView titleTextView;
    private TextView subtitleTextView;

    public CustomLayout(Context context) {
        super(context);
        init(context);
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_card, this, true);
        imageView = findViewById(R.id.image_view);
        titleTextView = findViewById(R.id.title_text_view);
    }
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    public void setImage(String imageSource) {
        int resId = getResources().getIdentifier(imageSource, "drawable", getContext().getPackageName());
        imageView.setImageResource(resId);
    }
    // Additional methods and logic for your CustomLayout class
}

