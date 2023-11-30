package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    private Button logInButton;
    private Button signUpNavButton;
    private TextView emailTextField;
    private TextView passwordTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Get Buttons
        logInButton = findViewById(R.id.logInButton);
        signUpNavButton = findViewById(R.id.signUpNavButton);

        // Get Text Fields
        emailTextField = findViewById(R.id.loginEmailTextField);
        passwordTextField = findViewById(R.id.loginPasswordTextField);

        //Set On Click Listeners
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logUserIn();
            }
        });

        signUpNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSignIn();
            }
        });
    }

    /*
     * Log User In
     * Description: Logs User In and Navigates to Home Page
     */
    private void logUserIn() {
        //Log User In
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        AuthenticationHandler.instance.loginUser(email, password, new LoginUserCallback() {
            @Override
            public void onComplete(FirebaseUser user) {
                navigateToHome();
            }

            @Override
            public void onError(String errorMessage) {
                //Display Error
            }
        });
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    /*
     * Navigate to Sign In
     * Description: Navigates to Sign In Page
     */
    private void navigateToSignIn() {
        finish();
    }
}