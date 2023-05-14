package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_delivery.ApiHandler.UserApiHandler;
import com.example.food_delivery.Fragemnts_signup.EnterPassword;
import com.example.food_delivery.Fragemnts_signup.EnterPhoneNumber;
import com.example.food_delivery.Fragemnts_signup.VerificationPhoneNumber;
import com.example.food_delivery.models.User;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Signup extends AppCompatActivity {
    TextView signin_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signin_text=findViewById(R.id.signin_text);

        signin_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                String URL = "http://192.168.1.4:80/"; String Url=getArguments().getString("url","");
                System.out.println("\n\n\n"+Url+"\n\n\n");
                if (!TextUtils.isEmpty(Url)) {
                    Retrofit Rf = new Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create()).build();
                    ApiHandler api = Rf.create(ApiHandler.class);
                    Call<User> adduser = api.insertUser(name, username, password, email);
                    adduser.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Response<User> response, Retrofit retrofit) {
                            if (response.isSuccess()) {
                                Toast.makeText(getActivity(), "User Add", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(getActivity().getApplication(), "Failed mochkla mil url" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });*/
                Intent intent = new Intent(Signup.this, Signin.class);
                startActivity(intent);
            }
        });


    }
}