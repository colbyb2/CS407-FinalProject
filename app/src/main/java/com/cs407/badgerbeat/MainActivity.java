package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button signUpButton;
    private Button logInNavButton;
    private TextView emailTextField;
    private TextView passwordTextField;
    private TextView confirmPassTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Buttons
        signUpButton = findViewById(R.id.signUpButton);
        logInNavButton = findViewById(R.id.logInNavButton);

        //Get Fields
        emailTextField = findViewById(R.id.signUpEmailTextField);
        passwordTextField = findViewById(R.id.signUpPasswordTextField);
        confirmPassTextField = findViewById(R.id.signUpConfirmPasswordTextField);


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

        //Init Auth
        AuthenticationHandler.instance.init();
    }

    @Override
    public void onStart() {
        super.onStart();
        //Check Auth
        FirebaseUser currentUser = AuthenticationHandler.instance.getCurrentUser();
        if (currentUser != null) {
            navigateToHome();
        }
    }

    /*
    * Sign User Up
    * Description: Signs User Up and Navigates to Home Page
    */
    private void signUserUp() {
        //Sign Up
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();
        String confirmPass = confirmPassTextField.getText().toString();

//        if (email.isEmpty() || password.isEmpty()) {
//            return;
//        } else if (password != confirmPass) {
//            return;
//        }
        AuthenticationHandler.instance.createUser(email, password, new CreateUserCallback() {
            @Override
            public void onComplete(FirebaseUser user) {
                //Navigate to Home
                navigateToHome();
            }

            @Override
            public void onError(String errorMessage) {
                //Display Errors
            }
        });
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
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