package com.example.pantherpark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.cognito.result.GlobalSignOutError;
import com.amplifyframework.auth.cognito.result.HostedUIError;
import com.amplifyframework.auth.cognito.result.RevokeTokenError;
import com.amplifyframework.core.Amplify;
import com.example.pantherpark.R;

public class HomePage extends AppCompatActivity {

    private Button signoutButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        signoutButton = findViewById(R.id.logoutButton);
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Amplify.Auth.signOut(signOutResult -> {
                    boolean b = signOutResult instanceof AWSCognitoAuthSignOutResult.CompleteSignOut;
                    {
                        // Sign Out completed fully and without errors.
                        Log.i("AuthQuickStart", "Signed out successfully");
                    }
                });

                finish();

            }

        });

    }

}