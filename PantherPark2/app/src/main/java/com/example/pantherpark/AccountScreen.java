package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

public class AccountScreen extends AppCompatActivity {

    private BottomNavigationView menu;

    private TextView name;
    private TextView email;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
        getSupportActionBar().setTitle("Account Information");

        /*
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
         */




        name = findViewById(R.id.nameLabel);
        email = findViewById(R.id.emailLabel);

        //Fetch user information and set them on the screen
        Amplify.Auth.fetchUserAttributes(new Consumer<List<AuthUserAttribute>>() {
            @Override
            public void accept(@NonNull List<AuthUserAttribute> attributes) {

                //Log.e("IS THIS NAME?", attributes.get(0).toString());
                //Log.e("IS THIS EMAIL?", attributes.get(1).toString());
                //Log.e("ATTRIBUTESSSSSSS", attributes.toString());
                //System.exit(0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        name.setText("Name:  " + attributes.get(2).getValue());
                        email.setText("Email:  " + attributes.get(3).getValue());
                    }
                });

                Log.i("AWS_AUTH_FETCH_USER_ATTR", "User attributes = " + attributes.toString());
            }
        }, new Consumer<AuthException>() {
            @Override
            public void accept(@NonNull AuthException error) {
                Log.e("AWS_AUTH_FETCH_USER_ATTR", "Failed to fetch user attributes.", error);
            }
        });

        menu = findViewById(R.id.bottomMenuAccount);
        menu.setSelectedItemId(R.id.account);
        menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Check which user selected
                switch (item.getItemId()) {
                    case R.id.parking:

                        //Quit the account screen and go back
                        finish();

                        return true;
                    case R.id.account:

                        //Do nothing, just stay on the current page

                        return true;
                }

                return false;
            }
        });


    }

    public void signOut(View view) {

        Amplify.Auth.signOut(new Consumer<AuthSignOutResult>() {
            @Override
            public void accept(@NonNull AuthSignOutResult signOutResult) {
                boolean b = signOutResult instanceof AWSCognitoAuthSignOutResult.CompleteSignOut;
                {
                    // Sign Out completed fully and without errors.
                    Log.i("AWS_AUTH_LOGOUT", "Signed out successfully");
                }
            }
        });

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

    }

    public void addSpot(View view) {
        Intent intent = new Intent(getApplicationContext(), AddParkingSpot.class);
        startActivity(intent);
    }

    public void deleteSpot(View view) {
        Intent intent = new Intent(getApplicationContext(), DeleteParkingSpot.class);
        startActivity(intent);
    }

}