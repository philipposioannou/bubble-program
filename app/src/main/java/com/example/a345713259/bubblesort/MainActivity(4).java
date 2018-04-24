package com.example.fikil.finalbubblesort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    int num[];
    Button startPauseButton;
    public TextView textOutput;
    Button stepButton;
    Button restartButton;
    boolean firsttime = true;
    boolean paused = false;
    boolean step = false;
    SortAlgorithm sortThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepButton = findViewById(R.id.button_step);
        startPauseButton = findViewById(R.id.button_start_pause);
        textOutput = findViewById(R.id.text_output);


        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firsttime) {
                    firsttime = false;
                    sortThread = new SortAlgorithm();
                    sortThread.start();
                    accessFiles();
                    sortThread.setnum(num);
                }
            }
        });

                            
                            
        stepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step = true;
            }
        });
    }


    public void accessFiles() {
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
}
