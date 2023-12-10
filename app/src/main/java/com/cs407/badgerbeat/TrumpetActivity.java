package com.cs407.badgerbeat;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class TrumpetActivity extends AppCompatActivity {

    // takes the user back to the previous activity
    private Button backButton;
    // store references for each button. Each button represents a trumpet valve
    private Button valve1, valve2, valve3;
    private RadioButton bugle0, bugle1, bugle2, bugle3;
    // represents whether the valve buttons are being held down
    private boolean[] valves = {false, false, false};
    // stores int values when sounds are loaded
    private int[] notes;
    // represents the current semitone (middle F = 13, Low E = 0)
    // Low F# is lowest standard tone on trumpet
    private int currentBugleTone = 13;
    private int currentNote;
    // SoundPool object that plays sounds
    private SoundPool pool;
    // TODO: implement more bugle tones using radio buttons
    private final int[] bugleTones = {6, 13, 18, 22};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trumpet);

        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // set buttons
        backButton = findViewById(R.id.backButton);
        valve1 = findViewById(R.id.valve1);
        valve2 = findViewById(R.id.valve2);
        valve3 = findViewById(R.id.valve3);

        // set bugle tones
        bugle0 = findViewById(R.id.bugle0);
        bugle1 = findViewById(R.id.bugle1);
        bugle2 = findViewById(R.id.bugle2);
        bugle3 = findViewById(R.id.bugle3);

        // initialize 'notes'
        notes = new int[31];

        // load trumpet tones into 'notes'
        // value of -1 indicates no audio file present
        notes[0] = -1;
        notes[1] = -1;
        notes[2] = -1;
        notes[3] = pool.load(this, R.raw.t03, 1);
        notes[4] = pool.load(this, R.raw.t04, 1);
        notes[5] = pool.load(this, R.raw.t05, 1);
        notes[6] = pool.load(this, R.raw.t06, 1);
        notes[7] = pool.load(this, R.raw.t07, 1);
        notes[8] = pool.load(this, R.raw.t08, 1);
        notes[9] = pool.load(this, R.raw.t09, 1);
        notes[10] = pool.load(this, R.raw.t10, 1);
        notes[11] = pool.load(this, R.raw.t11, 1);
        notes[12] = pool.load(this, R.raw.t12, 1);
        notes[13] = pool.load(this, R.raw.t13, 1);
        notes[14] = pool.load(this, R.raw.t14, 1);
        notes[15] = pool.load(this, R.raw.t15, 1);
        notes[16] = pool.load(this, R.raw.t16, 1);
        notes[17] = pool.load(this, R.raw.t17, 1);
        notes[18] = pool.load(this, R.raw.t18, 1);
        notes[19] = pool.load(this, R.raw.t19, 1);
        notes[20] = pool.load(this, R.raw.t20, 1);
        notes[21] = pool.load(this, R.raw.t21, 1);
        notes[22] = pool.load(this, R.raw.t22, 1);
        notes[23] = pool.load(this, R.raw.t23, 1);
        notes[24] = pool.load(this, R.raw.t24, 1);
        notes[25] = pool.load(this, R.raw.t25, 1);
        notes[26] = pool.load(this, R.raw.t26, 1);
        notes[27] = pool.load(this, R.raw.t27, 1);
        notes[28] = pool.load(this, R.raw.t28, 1);
        notes[29] = pool.load(this, R.raw.t29, 1);
        notes[30] = pool.load(this, R.raw.t30, 1);

        // detect which bugle tone is set
        bugle0.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.i("Trumpet", "bugle0: " + isChecked);
        });
        bugle1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.i("Trumpet", "bugle1: " + isChecked);
        });
        bugle2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.i("Trumpet", "bugle2: " + isChecked);
        });
        bugle3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.i("Trumpet", "bugle3: " + isChecked);
        });

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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHome();
            }
        });
    }

    // Determines which note to play based on which valves are pressed down
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
        if (notes[currentNote] != -1){
            pool.play(notes[currentNote], 1, 1, 0, 0, 1);
        }
    }

    // Returns to home page
    private void toHome() {
        finish();
    }
}