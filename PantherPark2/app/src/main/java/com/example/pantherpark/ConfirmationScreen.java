package com.example.pantherpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;

public class ConfirmationScreen extends AppCompatActivity {

    private EditText codeField;

    private TextView errorLabel;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        codeField = findViewById(R.id.codeField);
        errorLabel = findViewById(R.id.errorCodeLabel);

        email = getIntent().getStringExtra("EMAIL");


    }

    public void confirmCode(View view) {

        String confirmCode = codeField.getText().toString().trim();

        //Validate the code
        if(confirmCode.length() != 6){
            notProperLength();
            return;
        }
        else {

            Amplify.Auth.confirmSignUp(
                    email, confirmCode,
                    new Consumer<AuthSignUpResult>() {
                        @Override
                        public void accept(@NonNull AuthSignUpResult result) {
                            Log.i("AWS_AUTH_SUCCESS", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete");

                            //Hide the damn keyboard
                            hideKeyboard();

                            //Clear any errors
                            clearErrors();

                            FragmentManager fm = getSupportFragmentManager();
                            ConfirmationDialog cd = new ConfirmationDialog(view);
                            cd.show(fm, "Thank you!");

                        }
                    },
                    new Consumer<AuthException>() {
                        @Override
                        public void accept(@NonNull AuthException error) {
                            String errorCause = error.getCause().toString();
                            String errorException = error.toString();

                            Log.e("AWS_AUTH_FAIL_CAUSE", errorCause);
                            Log.e("AWS_AUTH_FAIL", errorException);

                            //CodeMismatchException
                            if(errorCause.contains("CodeMismatchException")){
                                CME();
                            }

                        }
                    });

        }


    }

    /**
     * CodeMismatchException
     */
    private void CME() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("Incorrect Code, please try again.");
            }
        });
    }

    private void notProperLength() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("Please enter a 6-digit numerical code.");
            }
        });
    }

    private void clearErrors(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                errorLabel.setText("");
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