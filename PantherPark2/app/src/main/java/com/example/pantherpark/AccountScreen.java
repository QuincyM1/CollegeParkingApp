package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.result.AuthSignOutResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;

public class AccountScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_screen);
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

}