package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button logInNavButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Buttons
        signUpButton = findViewById(R.id.signUpButton);
        logInNavButton = findViewById(R.id.logInNavButton);

        // Set Click Listeners
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUserUp();
            }
        });

        logInNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLogIn();
            }
        });
    }

    /*
    * Sign User Up
    * Description: Signs User Up and Navigates to Home Page
    */
    private void signUserUp() {
        //Sign Up
    }

    /*
     * Navigate to Log In
     * Description: Navigates to the Login Page
     */
    private void navigateToLogIn() {
        //Navigate To Login
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}