package com.example.food_delivery;

import static java.lang.Float.parseFloat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.MapTileIndex;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;
import java.util.List;

public class CheckIn extends AppCompatActivity {


    MapView map;
    Button btnOrder;
    private Polyline lineOverlay;
    private List<GeoPoint> pathPoints= new ArrayList<>();
    private Handler handler;
    private int delay = 2000;
    private int steps = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ckeck_in);

        initializeMap();

        // Your other code...
    }
    private void initializeMap() {
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        map = findViewById(R.id.mapView);
        map.getTileProvider().clearTileCache();
        Configuration.getInstance().setCacheMapTileCount((short) 12);
        Configuration.getInstance().setCacheMapTileOvershoot((short) 12);

        // Create a custom tile source
        map.setTileSource(new OnlineTileSourceBase("", 1, 20, 512, ".png",
                new String[]{"https://a.tile.openstreetmap.org/"}) {
            @Override
            public String getTileURLString(long pMapTileIndex) {
                return getBaseUrl()
                        + MapTileIndex.getZoom(pMapTileIndex)
                        + "/" + MapTileIndex.getX(pMapTileIndex)
                        + "/" + MapTileIndex.getY(pMapTileIndex)
                        + mImageFilenameEnding;
            }
        });

        map.setMultiTouchControls(true);
        IMapController mapController = map.getController();
        /*SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String addressString = sharedPreferences.getString("address", "");
        String latitude = sharedPreferences.getString("latitude","");
        String longitude = sharedPreferences.getString("longitude", "");*/

        GeoPoint startPoint = new GeoPoint(36.824973, 10.205228);
        Marker marker1=createmarker(36.824973,10.205228);
        GeoPoint secondPoint = new GeoPoint(36.832991, 10.231531);
        Marker marker2=createmarker(36.832991, 10.231531);
        simulateMovement(marker2, marker1);
        mapController.setZoom(11.0);
        mapController.setCenter(startPoint);
        map.invalidate();
    }
    private void simulateMovement(final Marker startMarker, final Marker endMarker) {
        final GeoPoint startPoint = startMarker.getPosition();
        final GeoPoint endPoint = endMarker.getPosition();
        final double stepLat = (endPoint.getLatitude() - startPoint.getLatitude()) / steps;
        final double stepLng = (endPoint.getLongitude() - startPoint.getLongitude()) / steps;

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            private int stepCount = 0;

            @Override
            public void run() {
                if (stepCount < steps) {
                    double lat = startPoint.getLatitude() + stepLat * stepCount;
                    double lng = startPoint.getLongitude() + stepLng * stepCount;
                    GeoPoint currentPosition = new GeoPoint(lat, lng);
                    startMarker.setPosition(currentPosition);
                    map.invalidate();
                    stepCount++;
                    handler.postDelayed(this, delay);
                    pathPoints.add(currentPosition);
                    if (lineOverlay != null) {
                        lineOverlay.setPoints(pathPoints);
                    }
                }
            }
        }, delay);
    }
    public Marker createmarker(double lat,double longi) {

        /*SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String addressString = sharedPreferences.getString("address", "");
        double latitude = sharedPreferences.getFloat("latitude", 0f);
        double longitude = sharedPreferences.getFloat("longitude", 0f);*/
        GeoPoint position = new GeoPoint(lat, longi);

        Marker myMarker = new Marker(map);
        myMarker.setPosition(position);
        myMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        myMarker.setTitle("Lac 1");
        myMarker.setPanToView(true);
        myMarker.setIcon(getResources().getDrawable(R.drawable.baseline_location)); // Set your desired marker icon here
        map.getOverlays().add(myMarker);

        IMapController mapController = map.getController();
        mapController.setZoom(11.0);
        mapController.setCenter(position);
        map.invalidate();
        return myMarker;
    }
}
