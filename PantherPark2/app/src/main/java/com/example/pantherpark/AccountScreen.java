package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AccountScreen extends AppCompatActivity {

    private BottomNavigationView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

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
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void deleteSpot(View view) {
        Intent intent = new Intent(getApplicationContext(), DeleteParkingSpot.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}