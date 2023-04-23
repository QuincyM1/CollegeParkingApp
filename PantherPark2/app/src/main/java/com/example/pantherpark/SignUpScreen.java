package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;

public class SignUpScreen extends AppCompatActivity {

    private EditText nameField;
    private EditText emailField;
    private EditText passwordField;
    private EditText confirmpasswordField;

    private String name;
    private String email;
    private String password;
    private String confirmpassword;

    private TextView lengthLabel;
    private TextView upperLowerNumberLabel;
    private TextView passwordsMatchLabel;
    private TextView emailErrorLabel;

    private int errorRed;
    private int successGreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        nameField = findViewById(R.id.nameFieldSignUp);
        emailField = findViewById(R.id.emailFieldSignUp);
        passwordField = findViewById(R.id.passwordFieldSignUp);
        confirmpasswordField = findViewById(R.id.confirmPasswordFieldSignUp);

        lengthLabel = findViewById(R.id.LenMatchedLabel);
        upperLowerNumberLabel = findViewById(R.id.LCUCNumMatchedLabel);
        passwordsMatchLabel = findViewById(R.id.passMatchedLabel);
        emailErrorLabel = findViewById(R.id.emailErrorLabel);

        errorRed = ContextCompat.getColor(getApplicationContext(), R.color.error_red);
        successGreen = ContextCompat.getColor(getApplicationContext(), R.color.success_green);

    }

    public void signUp(View view) {

        name = nameField.getText().toString().trim();
        email = emailField.getText().toString().trim();
        password = passwordField.getText().toString().trim();
        confirmpassword = confirmpasswordField.getText().toString().trim();

        //The requirements checking process
        boolean passLenCheck = checkPassLength(password);
        boolean passLowerUpperNumberCheck = checkIfUpperLowerAndNumExist(password);
        boolean passMatchConfirmCheck = passwordsMatch(password, confirmpassword);

        // Only if all requirements are met, invoke the sign up process
        if (passLenCheck && passLowerUpperNumberCheck && passMatchConfirmCheck) {

            // Add code here to register the user with the backend server
            AuthSignUpOptions options = AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), email).userAttribute(AuthUserAttributeKey.name(), name).build();


            Amplify.Auth.signUp(email, password, options, new Consumer<AuthSignUpResult>() {
                @Override
                public void accept(@NonNull AuthSignUpResult result) {

                    Log.i("AWS_AUTH_SUCCESS", "Result: " + result.toString());

                    //Hide the damn keyboard
                    hideKeyboard();

                    //Clear any errors
                    clearErrors();

                    //Remove Sign In screen from activity stack
                    SignInScreen.signinactivity.finish();

                    Intent intent = new Intent(getApplicationContext(), ConfirmationScreen.class);
                    intent.putExtra("EMAIL", email);
                    startActivity(intent);
                    finish();
                }
            }, new Consumer<AuthException>() {
                @Override
                public void accept(@NonNull AuthException error) {

                    String errorCause = error.getCause().toString();
                    String errorException = error.toString();

                    Log.e("AWS_AUTH_FAIL_CAUSE", errorCause);
                    Log.e("AWS_AUTH_FAIL", errorException);

                    // UsernameExistsException
                    if (errorCause.contains("UsernameExistsException")) {
                        // Alert user email already registered
                        UEE();
                    }
                    // InvalidParameterException
                    else if (errorCause.contains("InvalidParameterException")) {
                        //Alert user to input proper email
                        IPE();
                    }
                    //

                }
            });

        } else {
            return;
        }

    }

    private void clearErrors() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                emailErrorLabel.setText("");
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
                emailErrorLabel.setText("Please enter a valid email address.");
            }
        });
    }

    /**
     * UsernameExistsException
     */
    private void UEE() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                emailErrorLabel.setText("Email in use, please enter a new one or sign in.");
            }
        });
    }

    //✓✕
    //✔✘

    private boolean checkPassLength(String pass) {

        if (pass.length() < 8) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lengthLabel.setTextColor(errorRed);
                    lengthLabel.setText("✘ Password must be at least 8 characters");
                }
            });
            return false;
        } else if (pass.length() > 64) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lengthLabel.setTextColor(errorRed);
                    lengthLabel.setText("✘ Password too large");
                }
            });
            return false;
        } else {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lengthLabel.setTextColor(successGreen);
                    lengthLabel.setText("✔ Password is at least 8 characters");
                }
            });
            return true;
        }

    }

    private boolean checkIfUpperLowerAndNumExist(String pass) {

        boolean lowercase = false;
        boolean uppercase = false;
        boolean number = false;

        char ch;

        for (int i = 0; i < pass.length(); i++) {

            ch = pass.charAt(i);

            if (Character.isLowerCase(ch)) {
                lowercase = true;
            } else if (Character.isUpperCase(ch)) {
                uppercase = true;
            } else if (Character.isDigit(ch)) {
                number = true;
            }

            if (lowercase && uppercase && number) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        upperLowerNumberLabel.setTextColor(successGreen);
                        upperLowerNumberLabel.setText("✔ Password meets character requirements");
                    }
                });

                return true;
            }

        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                upperLowerNumberLabel.setTextColor(errorRed);
                upperLowerNumberLabel.setText("✘ Password must have at least 1 uppercase, 1 lowercase, and 1 digit");
            }
        });
        return false;

    }

    private boolean passwordsMatch(String password, String confirmpassword) {

        if (password.equals(confirmpassword)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    passwordsMatchLabel.setTextColor(successGreen);
                    passwordsMatchLabel.setText("✔ Passwords match");
                }
            });
            return true;
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    passwordsMatchLabel.setTextColor(errorRed);
                    passwordsMatchLabel.setText("✘ Passwords do not match");
                }
            });
            return false;
        }


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