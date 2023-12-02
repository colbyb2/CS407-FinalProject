package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Hashtable;

public class PianoActivity extends AppCompatActivity {
    private Button backButton;
    private Button c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        //Sets buttons
        backButton = findViewById(R.id.backButton);
        c2 = findViewById(R.id.c2);
        //Sets Media PLayer
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.key08c); //
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()) {
                    mp.stop();

                    mp.start();
                }
                mp.start(); //Plays note
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHome();
            }
        });
    }

    private void toHome() { //Returns to home page
        finish(); //Use finish to go back instead. Pops it off the intent stack.
    }
}