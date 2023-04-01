package com.example.pantherpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.core.Amplify;

public class LoginActivity extends AppCompatActivity {

    //

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Associate activity_login.xml layout file

        // Get references to the UI components in the layout file by their IDs
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);

        // Set click event listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the email and password entered by the user
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                //AuthSignInResult result;

                // Add code here to authenticate with the backend server
                Amplify.Auth.signIn(
                        email,
                        password,
                        result -> Log.i("AuthQuickstart", result.isSignedIn() ? "Sign in succeeded" : "Sign in not complete"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );

                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);

            }
        });


    }

    public void goToRegister(View view) {

        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);

    }


}
