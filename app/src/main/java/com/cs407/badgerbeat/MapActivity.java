package com.cs407.badgerbeat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {

    private GoogleMap mMap;

    private Button backButton;
    private ListView nearbyUserListView;

    private FusedLocationProviderClient mLocationProviderClient;

    private double[] nearbyLats = {43.056488, 43.075697, 43.074185};
    private double[] nearbyLongs = {-89.393048, -89.396334, -89.410137};
    private String[] users = {"Jim Jones - Piano", "Bob Johnson - Trumpet", "Barbara Smith - Any"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Get Button
        backButton = findViewById(R.id.mapBackButton);

        //Get List View
        nearbyUserListView = findViewById(R.id.nearbyUserListView);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_map);

        mapFragment.getMapAsync(googleMap -> {
            mMap = googleMap;
            mLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            showMyLocation();
            addNearbyUsers();
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showMyLocation();
            }
        }
    }

    private void showMyLocation() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            mMap.setMyLocationEnabled(true);
            mLocationProviderClient.getLastLocation()
                    .addOnCompleteListener(this, task -> {
                        Location location = task.getResult();
                        LatLng userLatLng = new LatLng(location.getLatitude(), location.getLongitude());

                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(userLatLng)
                                .zoom(10)
                                .build();

                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    });
        }
    }

    private void addNearbyUsers() {
        //Set list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        nearbyUserListView.setAdapter(adapter);

        nearbyUserListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedUser = (String) parent.getItemAtPosition(position);
                LatLng zoomLocation = new LatLng(nearbyLats[position], nearbyLongs[position]);

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(zoomLocation)
                        .zoom(15)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                String toastMessage = "Showing " + selectedUser + "'s Location";
                Toast.makeText(MapActivity.this, toastMessage,Toast.LENGTH_LONG).show();
            }
        });


        //Add Markers
        for (int i = 0; i < nearbyLats.length; i++) {
            double lat = nearbyLats[i];
            double longitude = nearbyLongs[i];
            LatLng markerLocation = new LatLng(lat, longitude);
            MarkerOptions markerOptions = new MarkerOptions()
                    .position(markerLocation)
                    .title("Nearby User " + (i + 1));
            mMap.addMarker(markerOptions);
        }
    }
}