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
        SoundPool pool = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);

        //Sets buttons
        backButton = findViewById(R.id.backButton);
        c2 = findViewById(R.id.c2);
        cs2 = findViewById(R.id.cs2);
        d2 = findViewById(R.id.d2);
        ds2 = findViewById(R.id.ds2);
        e2 = findViewById(R.id.e2);
        f2 = findViewById(R.id.f2);
        fs2 = findViewById(R.id.fs2);
        g2 = findViewById(R.id.g2);
        gs2 = findViewById(R.id.gs2);
        a3 = findViewById(R.id.a3);
        as3 = findViewById(R.id.as3);
        b3 = findViewById(R.id.b3);
        c3 = findViewById(R.id.c3);
        cs3 = findViewById(R.id.cs3);
        d3 = findViewById(R.id.d3);
        ds3 = findViewById(R.id.d3);
        //Sets Media PLayer

        int Pc1 = pool.load(this, R.raw.key08c, 1);
        int Pc1s = pool.load(this, R.raw.key09, 1);
        int Pd1 = pool.load(this, R.raw.key10, 1);
        int Pd1s = pool.load(this, R.raw.key11, 1);
        int Pe1 = pool.load(this, R.raw.key12, 1);
        int Pf1 = pool.load(this, R.raw.key13, 1);
        int Pf1s = pool.load(this, R.raw.key14, 1);
        int Pg1 = pool.load(this, R.raw.key15, 1);
        int Pg1s = pool.load(this, R.raw.key16, 1);
        int Pa1 = pool.load(this, R.raw.key17, 1);
        int Pas1 = pool.load(this, R.raw.key18, 1);
        int Pb1 = pool.load(this, R.raw.key19, 1);
        int Pc2 = pool.load(this, R.raw.key20, 1);
        int Pcs2 = pool.load(this, R.raw.key21, 1);
        int Pf2 = pool.load(this, R.raw.key22, 1);
        int Pfs2 = pool.load(this, R.raw.key23, 1);
        int Pg2 = pool.load(this, R.raw.key24, 1);
        //int Pgs2 = pool.load(this, R.raw.key17, 1);



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
        ds2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pd1s,1,1,0,0,1);
            }
        });
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pe1,1,1,0,0,1);
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pf1,1,1,0,0,1);
            }
        });
        fs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pf1s,1,1,0,0,1);
            }
        });

        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pg1,1,1,0,0,1);
            }
        });

        gs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pg1s,1,1,0,0,1);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pa1,1,1,0,0,1);
            }
        });

        as3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pas1,1,1,0,0,1);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pb1,1,1,0,0,1);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pc2,1,1,0,0,1);
            }
        });
        cs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pool.play(Pcs2,1,1,0,0,1);
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