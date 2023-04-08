package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pantherpark.databinding.ActivityMainBinding;
import com.google.android.gms.maps.*;


import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
import com.amplifyframework.core.Amplify;
import com.example.pantherpark.R;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.lang.reflect.Array;

public class HomePage extends AppCompatActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    /* ToDo: add onClick instances for existing and future buttons/lists,
        add responses to bottom nav options (Account, Park, Reservation),

     */
    MapView mapView;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    BottomNavigationView bottomNavigationView;
    boolean isPermissionGranted;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //check permissions for map
        //set up map
        mapView.onCreate(savedInstanceState);
        //set up bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.park:
                        spinner.setVisibility(View.VISIBLE);
                        Park park = new Park();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout3, park).commit();
                        return true;
                    case R.id.reservation:
                        spinner.setVisibility(View.GONE);
                        Reservation reservation = new Reservation();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout3, reservation).commit();
                        return true;
                    case R.id.account:
                        spinner.setVisibility(View.GONE);
                        Account account = new Account();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout3, account).commit();
                        return true;
                }
                return false;
            }
        });

        //mapview inside of frame located in activity_home_page xml
        mapView=findViewById(R.id.map);
        //Spinner showing list of destinations
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.destinations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // if user selects [Select A Destination]
                if (adapterView.getItemAtPosition(i).equals("Select a Destination")) {
                    Toast.makeText(adapter.getContext(), "Please Select a Destination", Toast.LENGTH_SHORT).show();
                }
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

    }

    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }
    @Override


    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}