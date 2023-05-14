package com.example.food_delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;
import java.util.Locale;

public class Welcome extends AppCompatActivity implements LocationListener {
    Button btnLogin, btnSignUp;
    TextView latLong, address;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(2000);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Signin.class);
                startActivity(intent);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, Signup.class);
                startActivity(intent);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                View view = getLayoutInflater().inflate(R.layout.my_dialog_welcome, null);
                latLong = view.findViewById(R.id.txt_permission2);
                address = view.findViewById(R.id.txt_permission3);
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Welcome.this);
                builder.setBackground(ContextCompat.getDrawable(Welcome.this, R.drawable.rounded_dialog_bg));
                Button customButton = view.findViewById(R.id.btn_permission);
                customButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getLocation();
                        Toast.makeText(Welcome.this, "Location retrieved!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(view);
                builder.show();
            }
        }, 1000);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    public void getLocation() {
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            startLocationUpdates();
            Log.d("Location", "Location permission granted");
        } else {
            Log.d("Location", "Location permission not granted. Requesting permission...");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        }
    }

    private void startLocationUpdates() {
        LocationCallback locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    double lat = location.getLatitude();
                    double longitude = location.getLongitude();
                    Log.d("Location", "Latitude:" + lat + ", Longitude: " + longitude);

                    Geocoder geocoder = new Geocoder(Welcome.this, Locale.getDefault());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(lat, longitude, 1);
                        latLong.setText("Latitude: " + lat + "\nLongitude: " + longitude);
                        address.setText("Address: " + addressList.get(0).getAddressLine(0));
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        String addressString = addressList.get(0).getAddressLine(0);
                        editor.putString("address", addressString);
                        editor.putString("latitude", String.valueOf(lat));
                        editor.putString("longitude", String.valueOf(longitude));
                        editor.apply();
                        Log.d("Location", "Address: " + addressList.get(0).getAddressLine(0));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 200) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                retrieveLocation();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void retrieveLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {
            double lat = location.getLatitude();
            double longitude = location.getLongitude();

            Log.d("Location", "Latitude: " + lat + ", Longitude: " + longitude);

            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                List<Address> addressList = geocoder.getFromLocation(lat, longitude, 1);
                latLong.setText("Latitude: " + lat + "\nLongitude: " + longitude);
                address.setText("Address: " + addressList.get(0).getAddressLine(0));

                Log.d("Location", "Address: " + addressList.get(0).getAddressLine(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
