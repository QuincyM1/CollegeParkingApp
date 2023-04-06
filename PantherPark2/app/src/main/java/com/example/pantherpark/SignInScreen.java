package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;

public class SignInScreen extends AppCompatActivity {

    // Fields
    private EditText emailField;
    private EditText passwordField;

    // Data
    private String email;
    private String password;

    // Labels
    private TextView errorLabel;

    public static SignInScreen signinactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        signinactivity = this;

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);

        errorLabel = findViewById(R.id.errorLabel);

    }

    public void signIn(View view){

        email = emailField.getText().toString().trim();
        password = passwordField.getText().toString().trim();

        // Authenticate with the backend server
        Amplify.Auth.signIn(
                email,
                password,
                new Consumer<AuthSignInResult>() {
                    @Override
                    public void accept(@NonNull AuthSignInResult result) {
                        Log.i("AWS_AUTH_SUCCESS", result.isSignedIn() ? "Sign in succeeded" : "Sign in not complete");

                        //Hide the damn keyboard
                        hideKeyboard();

                        //Clear error label of any errors, if applicable
                        clearErrors();

                        // Go to homepage if all sign in is a success
                        Intent intent = new Intent(getApplicationContext(), HomePage.class);
                        startActivity(intent);
                        finish();
                    }
                },
                new Consumer<AuthException>() {
                    @Override
                    public void accept(@NonNull AuthException error) {

                        String errorCause = error.getCause().toString();
                        String errorException = error.toString();

                        Log.e("AWS_AUTH_FAIL_CAUSE", errorCause);
                        Log.e("AWS_AUTH_FAIL", errorException);

                        //NotAuthorizedException
                        if(errorCause.contains("NotAuthorizedException")) {
                            //Alert user that they entered incorrect password
                            NTE();
                        }
                        //UserNotFoundException
                        else if(errorCause.contains("UserNotFoundException")) {
                            //Alert user that username of that email not found, register if needed.
                            UNFE();
                        }
                        //InvalidParameterException
                        else if(errorCause.contains("InvalidParameterException")) {
                            //Alert user that username is missing
                            IPE();
                        }
                    }
                }
        );

    }

    public void goToSignUp(View view){

        //Go to signup screen
        Intent intent = new Intent(getApplicationContext(), SignUpScreen.class);
        startActivity(intent);

    }

    private void clearErrors(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("");
            }
        });
    }

    /**
     * NotAuthorizedException
     */
    private void NTE() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("Incorrect Password: Please try again.");
            }
        });
    }

    /**
     * UserNotFoundException
     */
    private void UNFE() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("Unknown Email - Please enter a registered email" +
                        "\nor sign up.");
            }
        });
    }

    /**
     * InvalidParameterException
     */
    private void IPE() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("Please enter an email username.");
            }
        });
    }

    private void hideKeyboard() {
        Activity activity = this;
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}