package com.example.food_delivery.models;

public class OrderStatus {
    private Location location;
    private String Status;

    public static class Location {
        double Latitude;
        double Longitude;
        public Location(double lat, double lon){
            this.Latitude = lat;
            this.Longitude = lon;
        }
    }
}
