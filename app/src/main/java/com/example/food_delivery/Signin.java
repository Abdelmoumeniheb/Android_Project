package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.food_delivery.ApiHandler.UserApiHandler;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class Signin extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    TextView emailerrorEditText,passworderrorEditText,create_account_text;
    Button signinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        emailEditText = findViewById(R.id.email_edit);
        passwordEditText = findViewById(R.id.password_edit);
        emailerrorEditText = findViewById(R.id.emailerrorEditText);
        passworderrorEditText =findViewById(R.id.passworderrorEditText);
        signinBtn = findViewById(R.id.signin_btn);
        create_account_text=findViewById(R.id.create_account_text);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if(email.length() > 0){
                    emailerrorEditText.setText("");
                    emailerrorEditText.setClickable(false);
                    emailerrorEditText.setFocusable(false);
                }
                if(password.length() > 0){
                    passworderrorEditText.setText("");
                    passworderrorEditText.setClickable(false);
                    passworderrorEditText.setFocusable(false);
                }
                if(email.length() == 0 || password.length() == 0) {
                    // Set the button background tint to the default color
                    signinBtn.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.back_continue_singin));
                    signinBtn.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.txt_continue_singin));
                    passwordEditText.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.color_2_page_singin));
                    emailEditText.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.color_2_page_singin));
                } else {
                    // Set the button background tint to a different color
                    signinBtn.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.secondly));
                    signinBtn.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    passwordEditText.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.primary));
                    emailEditText.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.primary));

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailEditText.getText().toString().length() == 0 )
                {
                    emailerrorEditText.setText("Email is required");
                    emailerrorEditText.setClickable(true);
                    emailerrorEditText.setFocusable(true);
                    emailEditText.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.secondly));

                }
                if(passwordEditText.getText().toString().length() == 0)
                {
                    passworderrorEditText.setText("Password is required!");
                    passworderrorEditText.setClickable(true);
                    passworderrorEditText.setFocusable(true);
                    passwordEditText.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.secondly));
                }
                else if (emailEditText.getText().toString().length() != 0 && passwordEditText.getText().toString().length() != 0)
                {Intent intent;
                    intent = new Intent(Signin.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        Button signin_btn;
        signin_btn=findViewById(R.id.signin_btn);
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            Intent intent = new Intent(Signin.this, MainActivity.class);
                            startActivity(intent);
            }
        });

    }
}