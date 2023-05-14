package com.example.food_delivery.models;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    public class Login{
        private String user;
        private String pass;
        public Login(String user,String pass){
            this.user = user;
            this.pass = pass;
        }
    }
    /*private List<String> dietaryRestrictions;
    private List<Order> orderHistory;
    private List<PaymentMethod> paymentMethods;*/
}
