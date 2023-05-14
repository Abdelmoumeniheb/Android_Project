package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Onboarding extends AppCompatActivity {
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        ViewPager viewPager = findViewById(R.id.view_pager);
        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this);
        viewPager.setAdapter(adapter);
        nextButton = findViewById(R.id.btn_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem < adapter.getCount() - 1) {
                    viewPager.setCurrentItem(currentItem + 1);
                } else {

                    startActivity(new Intent(Onboarding.this, Welcome.class));
                    finish();
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // not needed
            }
            @Override
            public void onPageSelected(int position) {
                // check if the current item is the last slide and update the button text accordingly
                if (position == adapter.getCount() - 1) {
                    nextButton.setText("Get Started");
                } else {
                    nextButton.setText("Next");
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                // not needed
            }
        });
    }
}