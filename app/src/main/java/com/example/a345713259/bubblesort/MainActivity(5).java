package com.example.fikil.finalbubblesort;

/*      Name: Filippos Ioannou
        Assignment: Bubble Sort Algorithm
        Course Code:ICS4U1-02
        Date:02/05/2018
        */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements MainActivityInterface {

//Button objects for the sorting, stepping and pausing

    public TextView textOutput;
    Button startPauseButton;
    Button stepButton;
    Button resetButton;
    boolean firsttime = true;
    ButtonController buttonController = new ButtonController();
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetButton = findViewById(R.id.button_reset);
        stepButton = findViewById(R.id.button_step);
        startPauseButton = findViewById(R.id.button_start);
        textOutput = findViewById(R.id.text_output);

        buttonController.setMainActivity(this);

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if sort is pressed for the first time since starting the app or since pressing the reset button,
                *the text changes to "pause" and the step button becomes disabled
                *otherwise the text reads sort and the step button becomes enables
                *see button controller class for algorithm related functions
                */
                if (firsttime) {
                    firsttime = false;
                    buttonController.firsttimestartPauseButtonClick(context);
                    startPauseButton.setText("pause");
                    stepButton.setEnabled(false);
                } else {
                    startPauseButton.setText("sort");
                    buttonController.notFirsttimestartPauseButtonClick();
                    stepButton.setEnabled(true);
                }
            }
        });


        stepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonController.stepButtonOnClick();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*reset the textOutput to initial values, changes the StartPauseButton to read "sort"
                * and change firsttime to true
                * see button controller class for algorithm related functions
                * */

                buttonController.resetButtonOnClick(context);
                startPauseButton.setText("sort");
                firsttime = true;
                textOutput.setText(buttonController.sortThread.result);

            }
        });


    }

    public void update(final String Result) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                textOutput.setText(Result);
            }
        });
    }

}
