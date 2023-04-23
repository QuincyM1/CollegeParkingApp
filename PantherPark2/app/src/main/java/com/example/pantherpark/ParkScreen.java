package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.pantherpark.dbinterface.DBManager;
import com.example.pantherpark.dbinterface.DeckData;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ParkScreen extends AppCompatActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    BottomNavigationView bottomNavigationView;

    FusedLocationProviderClient f;
    LatLng selection = new LatLng(0, 0);

    LatLng InitialPosition = new LatLng(0,0);
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        f = LocationServices.getFusedLocationProviderClient(this);
        setContentView(R.layout.activity_park_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //check permissions for map
        //set up map
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        mapFragment.getMapAsync(this);

        //set up bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.parking:

                        return true;
                    case R.id.account:

                        Intent intent = new Intent(ParkScreen.this, AccountScreen.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });

        //mapview inside of frame located in activity_home_page xml
        //Spinner showing list of destinations
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.decks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                DBManager dbmg = new DBManager();
                DeckData deck = dbmg.getDeckInformation("A Deck");
                // if user selects [Select A Destination]
                if (adapterView.getItemAtPosition(i).equals("Select a Destination")) {
                    clearMarker(mMap);
                    Toast.makeText(adapter.getContext(), "Please Select a Destination", Toast.LENGTH_SHORT).show();
                    resetPosition(mMap);
                }
                else {
                    clearMarker(mMap);
                    selection = deck.getLatLng();
                    makePosition(mMap, selection, adapterView.getItemAtPosition(i).toString());
                }

                /*if (adapterView.getItemAtPosition(i).equals("B Deck")) {
                    clearMarker(mMap);
                    selection = new LatLng(33.7521941, -84.3856621);
                    makePosition(mMap, selection, adapterView.getItemAtPosition(i).toString());

                }*/
                //makePosition(mMap, getDeckLatLng(adapterView.getItemAtPosition(i).toString()), adapterView.getItemAtPosition(i).toString());


                //Gets destination from user selection and creates a string
                String destinationToText = spinner.getSelectedItem().toString();
                // ToDo: add prompt to find closest decks and display them onscreen
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng InitialPosition = new LatLng(33.7488, -84.3877);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(InitialPosition, 14));
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        f.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    LatLng InitialPosition = new LatLng(location.getLatitude(), location.getLongitude());
                }
            }
        });
    }


    public void makePosition(@NonNull GoogleMap googleMap, LatLng LL, String s) {
        CameraPosition cameraPosition = new CameraPosition.Builder().target(LL).zoom(18).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1500, new GoogleMap.CancelableCallback() {
            @Override
            public void onCancel() {

            }

            @Override
            public void onFinish() {

            }
        });
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(selection, 18));
        googleMap.addMarker(new MarkerOptions().position(selection).title(s));
    }

    public void resetPosition(@NonNull GoogleMap googleMap) {
        //LatLng InitialPosition = new LatLng(33.7488, -84.3877);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(InitialPosition).zoom(14).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1500, new GoogleMap.CancelableCallback() {
            @Override
            public void onCancel() {

            }

            @Override
            public void onFinish() {

            }
        });
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(InitialPosition, 14));
    }

    public void clearMarker(@NonNull GoogleMap googleMap) {
        googleMap.clear();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}