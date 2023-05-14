package com.example.food_delivery.Validation;

public class phoneNumberValidation {
    public static boolean testdigit(String str){
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    public static String isValidPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 0){
            return "The phone number cannot be empty.";
        }else if (!testdigit(phoneNumber)) {
            return "The phone number can only contain numeric digits.";
        }
        else if (phoneNumber.length() != 8 && testdigit(phoneNumber)) {
            return "The phone number must have 8 digits and cannot contain non-numeric characters.";
        } else if (phoneNumber.length() != 8) {
            return "The phone number must have exactly 8 digits.";
        }  else {
            return "The phone number is valid.";
        }
    }

}
