package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.os.Handler;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthSession;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthSession;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //Initialize backend
        try {
            Amplify.addPlugin(new AWSApiPlugin()); // UNCOMMENT this line once backend is deployed
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("Amplify", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("Amplify", "Could not initialize Amplify", error);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                //Check to see if the user is signed in
                Amplify.Auth.fetchAuthSession(
                        new Consumer<AuthSession>() {
                            @Override
                            public void accept(@NonNull AuthSession result) {
                                AWSCognitoAuthSession cognitoAuthSession = (AWSCognitoAuthSession) result;
                                switch (cognitoAuthSession.getIdentityIdResult().getType()) {
                                    case SUCCESS:
                                        Log.i("AuthQuickStart", "IdentityId: " + cognitoAuthSession.getIdentityIdResult().getValue());

                                        Intent intent1 = new Intent(MainActivity.this, HomePage.class);
                                        startActivity(intent1);
                                        finish();

                                        break;
                                    case FAILURE:
                                        Log.i("AuthQuickStart", "IdentityId not present because: " + cognitoAuthSession.getIdentityIdResult().getError().toString());

                                        Intent intent2 = new Intent(MainActivity.this, SignInScreen.class);
                                        startActivity(intent2);
                                        finish();
                                }
                            }
                        },
                        new Consumer<AuthException>() {
                            @Override
                            public void accept(@NonNull AuthException error) {
                                Log.e("AuthQuickStart", error.toString());
                            }
                        }
                );
            }
        }, 3000);

        /*
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(MainActivity.this, SignInScreen.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

         */
    }

    //Method for Map Implementation - Zoyie
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}