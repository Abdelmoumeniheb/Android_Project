package com.example.food_delivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OnboardingPagerAdapter extends PagerAdapter {

    private final Context context;
    private final List<Integer> slides = new ArrayList<>();

    public OnboardingPagerAdapter(Context context) {
        this.context = context;
        slides.add(R.layout.onboarding_slide);
        slides.add(R.layout.onboarding_slide2);
        slides.add(R.layout.onboarding_slide3);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(slides.get(position), container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView((LinearLayout) obj);
    }

    @Override
    public int getCount() {
        return slides.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
