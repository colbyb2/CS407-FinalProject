package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Hashtable;

public class PianoActivity extends AppCompatActivity {
    private Button backButton;
    private Button c2, cs2, d2, ds2, e2, f2, fs2, g2, gs2, a3, as3, b3, c3, cs3, d3, ds3, e3,
    f3, fs3, g3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        SoundPool pool = new SoundPool(24, AudioManager.STREAM_MUSIC, 0);

        //Sets buttons
        backButton = findViewById(R.id.backButton);
        c2 = findViewById(R.id.c2);
        cs2 = findViewById(R.id.cs2);
        d2 = findViewById(R.id.d2);
        //Sets Media PLayer

        int Pc1 = pool.load(this, R.raw.key08c, 1);
        int Pc1s = pool.load(this, R.raw.key09, 1);
        int Pd1 = pool.load(this, R.raw.key10, 1);
        int Pd1s = pool.load(this, R.raw.key11, 1);
        int Pe1 = pool.load(this, R.raw.key12, 1);
        int Pf1 = pool.load(this, R.raw.key12, 1);
        int Pf1s = pool.load(this, R.raw.key12, 1);
        int Pg1 = pool.load(this, R.raw.key12, 1);
        int Pg1s = pool.load(this, R.raw.key12, 1);
        int Pa1 = pool.load(this, R.raw.key12, 1);


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pc1, 1, 1, 0, 0, 1);
            }
        });

        cs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pc1s, 1, 1, 0, 0, 1);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pd1, 1,1,0,0,1);
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