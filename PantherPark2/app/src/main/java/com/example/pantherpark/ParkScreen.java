package com.example.pantherpark;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.pantherpark.data_objects.FindingMinDistance;
import com.example.pantherpark.dbinterface.DBManager;
import com.example.pantherpark.dbinterface.DeckData;
import com.example.pantherpark.sensorservice.VirtualSensorService;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class ParkScreen extends AppCompatActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    BottomNavigationView bottomNavigationView;

    FusedLocationProviderClient f;
    LatLng selection = new LatLng(0, 0);
    Button button;
    LatLng InitialPosition;
    GoogleMap mMap;

    private TextView available;
    private TextView unavailable;
    private TextView total;

    private MapView gmapcontainer;

    DBManager dbmg = new DBManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        f = LocationServices.getFusedLocationProviderClient(this);
        setContentView(R.layout.activity_park_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        available = findViewById(R.id.available);
        unavailable = findViewById(R.id.unavailable);
        total = findViewById(R.id.total);

        gmapcontainer = findViewById(R.id.map);

        //check permissions for map
        //set up map
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        mapFragment.getMapAsync(this);

        getLocation(f);

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
                        return false;
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
                DeckData deck = dbmg.getDeckInformation(adapterView.getItemAtPosition(i).toString());
                // if user selects [Select A Destination]
                if (adapterView.getItemAtPosition(i).equals("Select a Destination")) {
                    clearMarker(mMap);
                    Toast.makeText(adapter.getContext(), "Please Select a Destination", Toast.LENGTH_SHORT).show();

                    setMargins(gmapcontainer, 0, 48, 0, 0);

                    available.setText(" ");
                    unavailable.setText(" ");
                    total.setText(" ");

                    resetPosition(mMap);
                } else {
                    clearMarker(mMap);
                    selection = deck.getLatLng();
                    resetPosition(mMap);
                    makePosition(mMap, selection, adapterView.getItemAtPosition(i).toString());

                    VirtualSensorService vss = new VirtualSensorService();
                    int[] spotStats = vss.howManySpotsAvailable(adapterView.getItemAtPosition(i).toString());

                    available.setText("Open: " + spotStats[0]);
                    unavailable.setText("Taken: " + spotStats[1]);
                    total.setText("Total Spots: " + spotStats[2]);

                    setMargins(gmapcontainer, 0, 96, 0, 0);
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
        FindingMinDistance r = new FindingMinDistance();
        button = findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<DeckData> decks = dbmg.getDecks();
                DeckData currentDeck;
                currentDeck = r.minDistance(decks, getLocation(f));
                Toast.makeText(ParkScreen.this, currentDeck.getDeckName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void setMargins(View v, float l, float t, float r, float b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, l, getApplicationContext().getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, t, getApplicationContext().getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, r, getApplicationContext().getResources().getDisplayMetrics()),
                    (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, b, getApplicationContext().getResources().getDisplayMetrics())
            );
            v.requestLayout();
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng InitialPosition = new LatLng(33.7488, -84.3877);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(InitialPosition, 10));
        mMap = googleMap;
    }


    public void makePosition(GoogleMap googleMap, LatLng LL, String s) {

        if (googleMap != null) {
            CameraPosition cameraPosition = new CameraPosition.Builder().target(LL).zoom(18).build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1500, new GoogleMap.CancelableCallback() {
                @Override
                public void onCancel() {
                    //Do nothing
                }

                @Override
                public void onFinish() {

                }
            });
            //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(selection, 18));
            googleMap.addMarker(new MarkerOptions().position(LL).title(s));
        }

    }

    public void resetPosition(GoogleMap googleMap) {

        if (googleMap != null) {
            LatLng InitialPosition = new LatLng(33.7488, -84.3877);
            //InitialPosition = getLocation(f);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(InitialPosition).zoom(10).build();
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
    }

        public void clearMarker (GoogleMap googleMap){
            if (googleMap != null) {
                googleMap.clear();
            }
        }

        @SuppressLint("MissingPermission")
        public LatLng getLocation (FusedLocationProviderClient f) {
            LocationRequest mLocationRequest = LocationRequest.create();
            mLocationRequest.setInterval(60000);
            mLocationRequest.setFastestInterval(5000);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            LocationCallback mLocationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    if (locationResult == null) {
                        return;
                    }
                    for (Location location : locationResult.getLocations()) {
                        if (location != null) {
                            //TODO: UI updates.
                        }
                    }
                }
            };
            LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest, mLocationCallback, null);
            f.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        InitialPosition = new LatLng(location.getLatitude(), location.getLongitude());
                    }
                }
            });
            return InitialPosition;
        }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}