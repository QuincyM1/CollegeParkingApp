package com.example.pantherpark;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;

public class RegisterActivity extends AppCompatActivity {

    //

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button registerButton;

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
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);
        registerButton = findViewById(R.id.register_button);

        // Set click event listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the email and passwords entered by the user
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Add code here to register the user with the backend server
                Amplify.Auth.signUp(
                        name,
                        password,
                        AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email).build(),
                        result -> Log.i("Amplify Auth", "Result: " + result.toString()),
                        error -> Log.e("Amplify Auth", "Sign up failed", error)
                );

                // Display a simple Toast message
                Toast.makeText(RegisterActivity.this, "Register button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
