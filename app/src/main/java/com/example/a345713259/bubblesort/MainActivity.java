package com.example.a345713259.bubblesort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import android.view.View.OnClickListener;


//*
// Filippos Ioannou
// ICS4U1-02
// */

public class MainActivity extends AppCompatActivity {


    int num[];
    boolean wait;
    Button startPauseButton;
    TextView textOutput;
    Button stepButton;
    Button restartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startPauseButton = findViewById(R.id.button_start_pause);
        textOutput = findViewById(R.id.text_output);
        stepButton = findViewById(R.id.button_step);
        restartButton = findViewById(R.id.button_reset);



        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessFiles();
                sortAlgorithm();

            }
        });
    }



    public void accessFiles () {
        // Accessing the testcase file
        InputStream dataSetFileInputStream = getResources().openRawResource(R.raw.test_case_4);
        Scanner scanner = new Scanner(dataSetFileInputStream);
        num = new int[15];

        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }

        try {
            dataSetFileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void sortAlgorithm() {

        int n = num.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (num[j - 1] > num[j]) {
                    //swap elements
                    wait = true;
                    temp = num[j - 1];
                    num[j - 1] = num[j];
                    num[j] = temp;

                    //print the results
                    String result = "";
                    for (int k = 0; k < num.length; k++) {
                        result += num[k] + " ";
                    }
                    final String Result = result;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textOutput.setText(Result);
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        }
    }
}



/*if (firsttime) {
                    firsttime = true;*/

/*} else {
                    if (paused)
                        paused = false;
                    else
                        paused = true;*/
/*if (pause == false) {
                    startPauseButton.setText("Pause");
                    pause = true;
                } else {
                    startPauseButton.setText("Sort");
                    pause = false;
public void Restart() {
    restartButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });
}



/*





/*Intent intent = getIntent();
                finish();
                startActivity(intent);


                // Changes made, thread starts again
            }
        });
    */







/*stepButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                wait = false;
            }
        }); */








//change the speed of the algorithm using the SeekBar
                /*changeSpeedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progressBar.setProgress(progress);
                        seekBarOutput.setText("" + progress + "%");


                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        });
    }
}
public void restartAlgorithm() {

                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

            }









*/
