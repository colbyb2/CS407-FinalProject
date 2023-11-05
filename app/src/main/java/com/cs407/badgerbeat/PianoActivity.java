package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PianoActivity extends AppCompatActivity {
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        //Sets buttons
        backButton = findViewById(R.id.backButton);
        //Sets Media PLayer
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.key01);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start(); //Plays song
                toHome();
            }
        });
    }

    private void toHome() { //Returns to home page
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}