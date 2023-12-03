package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    private Button pianoButton;
    private Button trumpetButton;
    private Button logoutButton;
    private Button findMusiciansButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Get Buttons
        pianoButton = findViewById(R.id.pianoButton);
        trumpetButton = findViewById(R.id.trumpetButton);
        logoutButton = findViewById(R.id.logoutButton);
        findMusiciansButton = findViewById(R.id.findMusiciansButton);

        pianoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPiano();
            }
        });

        trumpetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTrumpet();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticationHandler.instance.signUserOut();
                finish();
            }
        });

        findMusiciansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMap();
            }
        });
    }

    private void toPiano() {
        Intent intent = new Intent(this, PianoActivity.class);
        startActivity(intent);
    }

    private void toTrumpet() {
        Intent intent = new Intent(this, TrumpetActivity.class);
        startActivity(intent);
    }

    private void toMap() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}