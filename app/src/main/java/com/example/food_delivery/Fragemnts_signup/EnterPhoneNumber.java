package com.example.food_delivery.Fragemnts_signup;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.food_delivery.R;
import com.example.food_delivery.Validation.phoneNumberValidation;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.type.PhoneNumber;
public class EnterPhoneNumber extends Fragment {
    Button btn;
    EditText phoneEditText;
    TextView PhoneNumberErrorText;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnterPhoneNumber() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnterPhoneNumber.
     */
    // TODO: Rename and change types and number of parameters
    public static EnterPhoneNumber newInstance(String param1, String param2) {
        EnterPhoneNumber fragment = new EnterPhoneNumber();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_enter_phone_number, container, false);
        btn=v.findViewById(R.id.btn);
        phoneEditText=v.findViewById(R.id.phonenumber_edit);
        PhoneNumberErrorText=v.findViewById(R.id.PhoneNumberErrorText);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                String phonenumber = phoneEditText.getText().toString().trim();
                if(phonenumber.length() > 0){
                    PhoneNumberErrorText.setText("");
                    PhoneNumberErrorText.setClickable(false);
                    PhoneNumberErrorText.setFocusable(false);
                }
                if(phonenumber.length() == 0 ) {
                    // Set the button background tint to the default color
                    btn.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.back_continue_singin));
                    btn.setTextColor(ContextCompat.getColor(getContext(), R.color.txt_continue_singin));
                    phoneEditText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.color_2_page_singin));
                } else {
                    // Set the button background tint to a different color
                    btn.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.secondly));
                    btn.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                    phoneEditText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.primary));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }


        };
        phoneEditText.addTextChangedListener(textWatcher);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String msg = phoneNumberValidation.isValidPhoneNumber(phoneEditText.getText().toString().trim());
                    if(msg!="The phone number is valid."){
                        PhoneNumberErrorText.setText(msg);
                        PhoneNumberErrorText.setClickable(true);
                        PhoneNumberErrorText.setFocusable(true);
                    }
                    PhoneNumberErrorText.setBackgroundTintList(ContextCompat.getColorStateList(getContext(), R.color.secondly));
                }
        });
        return v;
    }

}