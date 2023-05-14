package com.example.food_delivery.Validation;

public class PasswordValidation {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }
}
