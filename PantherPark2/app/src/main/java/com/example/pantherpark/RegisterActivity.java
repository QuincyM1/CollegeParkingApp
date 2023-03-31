package com.example.pantherpark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;

public class RegisterActivity extends AppCompatActivity {

    //

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmCodeEditText;
    private Button registerButton;
    private Button confirmButton;

    private String name;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Associate activity_register.xml layout file

        /*
        try {
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("", "Could not initialize Amplify", error);
        }
        */

        // Get references to the UI components in the layout file by their IDs
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        registerButton = findViewById(R.id.register_button);
        confirmButton = findViewById(R.id.confirm_button);

        // Set click event listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the email and passwords entered by the user
                name = nameEditText.getText().toString().trim();
                email = emailEditText.getText().toString().trim();
                password = passwordEditText.getText().toString().trim();

                /*
                try {
                    // Add this line, to include the Auth plugin.
                    Amplify.addPlugin(new AWSCognitoAuthPlugin());
                    Amplify.configure(getApplicationContext());
                }
                catch (Exception e) {
                    Log.e("Amplify Exception", e.toString());
                }
                */

                // Add code here to register the user with the backend server

                AuthSignUpOptions options = AuthSignUpOptions.builder()
                        .userAttribute(AuthUserAttributeKey.email(), email)
                        .userAttribute(AuthUserAttributeKey.name(), name)
                        .build();

                Amplify.Auth.signUp(email, password, options,
                        result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                        error -> Log.e("AuthQuickStart", "Sign up failed", error)
                );

                /*
                Amplify.Auth.signUp(
                        name,
                        password,
                        AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email).build(),
                        result -> Log.i("Amplify Auth", "Result: " + result.toString()),
                        error -> Log.e("Amplify Auth", "Sign up failed", error)
                );
                */

                // Display a simple Toast message
                Toast.makeText(RegisterActivity.this, "Register button clicked", Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(getApplicationContext(), ConfirmCodeActivity.class);
                //startActivity(intent);


            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmCodeEditText = findViewById(R.id.confirm_password_edit_text);
                String confirmCode = confirmCodeEditText.getText().toString().trim();

                Amplify.Auth.confirmSignUp(
                        email,
                        confirmCode,
                        result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
                        error -> Log.e("AuthQuickstart", error.toString())
                );

            }
        });

    }
}
