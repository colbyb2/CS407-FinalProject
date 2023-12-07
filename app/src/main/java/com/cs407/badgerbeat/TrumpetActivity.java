package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class TrumpetActivity extends AppCompatActivity {

    // takes the user back to the previous activity
    private Button backButton;
    // store references for each button. Each button represents a trumpet valve
    private Button valve1, valve2, valve3;
    // represents whether the valve buttons are being held down
    private boolean[] valves = {false, false, false};
    // TODO: create an array for notes, with G = 13, C = 6, Low F# = 0 (each value corresponds to a semitone)
    // represents the current semitone (middle G = 13, Low F# = 0)
    // Low F# is lowest standard tone on trumpet
    private int currentBugleTone = 13;
    private int currentNote;
    // TODO: play the correct note for the valves held down
    // TODO: implement more bugle tones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trumpet);

        //SoundPool pool = new SoundPool(50, AudioManager.STREAM_MUSIC, 0);

        // set buttons
        backButton = findViewById(R.id.backButton);
        valve1 = findViewById(R.id.valve1);
        valve2 = findViewById(R.id.valve2);
        valve3 = findViewById(R.id.valve3);

        // detect when the buttons (valves) are pressed down
        valve1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //Log.i("Trumpet", "Valve 1 Pressed");
                        valves[0] = true;
                        //Log.i("Trumpet", "Valve 1: " + valves[0]);
                        playNote();
                        return true;
                    case MotionEvent.ACTION_UP:
                        //Log.i("Trumpet", "Valve 1 Released");
                        valves[0] = false;
                        //Log.i("Trumpet", "Valve 1: " + valves[0]);
                        playNote();
                        return true;
                }

                return false;
            }
        });
        valve2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //Log.i("Trumpet", "Valve 2 Pressed");
                        valves[1] = true;
                        //Log.i("Trumpet", "Valve 2: " + valves[1]);
                        playNote();
                        return true;
                    case MotionEvent.ACTION_UP:
                        //Log.i("Trumpet", "Valve 2 Released");
                        valves[1] = false;
                        //Log.i("Trumpet", "Valve 2: " + valves[1]);
                        playNote();
                        return true;
                }

                return false;
            }
        });
        valve3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //Log.i("Trumpet", "Valve 3 Pressed");
                        valves[2] = true;
                        //Log.i("Trumpet", "Valve 3: " + valves[2]);
                        playNote();
                        return true;
                    case MotionEvent.ACTION_UP:
                        //Log.i("Trumpet", "Valve 3 Released");
                        valves[2] = false;
                        //Log.i("Trumpet", "Valve 3: " + valves[2]);
                        playNote();
                        return true;
                }

                return false;
            }
        });
    }

    public void playNote(){
        if (valves[0]){
            if(valves[1]){
                if(valves[2]){
                    // 1,2,3
                    currentNote = currentBugleTone - 6;
                } else{
                    // 1,2
                    currentNote = currentBugleTone - 3;
                }
            } else {
                if(valves[2]){
                    // 1,3
                    currentNote = currentBugleTone - 5;
                } else{
                    // 1
                    currentNote = currentBugleTone - 2;
                }
            }
        } else {
            if(valves[1]){
                if(valves[2]){
                    // 2,3
                    currentNote = currentBugleTone - 4;
                } else{
                    // 2
                    currentNote = currentBugleTone - 1;
                }
            } else {
                if(valves[2]){
                    // 3
                    currentNote = currentBugleTone - 3;
                } else{
                    // 0 (open valves)
                    currentNote = currentBugleTone;
                }
            }
        }

        Log.i("Trumpet", "Current semitone: " + currentNote);
    }
}