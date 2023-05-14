package com.example.food_delivery.Fragements_Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.food_delivery.Content.restaurantContent;
import com.example.food_delivery.MenuActivity;
import com.example.food_delivery.R;
import com.example.food_delivery.SearchActivity;
import com.example.food_delivery.models.restaurant;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BasicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BasicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BasicFragment newInstance(String param1, String param2) {
        BasicFragment fragment = new BasicFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_basic, container, false);
        getActivity().setTheme(R.style.MyFragmentTheme);
        TextView textViewaddress = v.findViewById(R.id.textViewaddress);
        HorizontalScrollView horizontalScrollView = v.findViewById(R.id.scrollView);
        LinearLayout containerLayout = new LinearLayout(getContext());
        containerLayout.setOrientation(LinearLayout.HORIZONTAL);
        ArrayList<restaurant> listeRestaurant = restaurantContent.getRestaurants();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String address = sharedPreferences.getString("address", "");
        textViewaddress.setText(address);
        for (int i = 0; i < 5; i++) {
            restaurant currentRestaurant = listeRestaurant.get(i);
            CustomLayout itemLayout = new CustomLayout(getContext());
            itemLayout.setTitle(currentRestaurant.getName());
            itemLayout.setImage(currentRestaurant.getImage());
            containerLayout.addView(itemLayout);
        }
        horizontalScrollView.addView(containerLayout);
        AppCompatEditText searchInput =v.findViewById(R.id.search_input);
        ImageView menu_icon = v.findViewById(R.id.menu_icon);
        searchInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with a new fragment
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}