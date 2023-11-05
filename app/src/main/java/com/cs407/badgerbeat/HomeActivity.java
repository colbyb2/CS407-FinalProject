package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    private Button pianoButton;
    private Button trumpetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Get Buttons
        pianoButton = findViewById(R.id.pianoButton);
        trumpetButton = findViewById(R.id.trumpetButton);

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
    }

    private void toPiano() {
        Intent intent = new Intent(this, PianoActivity.class);
        startActivity(intent);
    }

    private void toTrumpet() {
        Intent intent = new Intent(this, TrumpetActivity.class);
        startActivity(intent);
    }
}