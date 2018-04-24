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
    Thread sortThread;


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

                    sortThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            
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

    public void setoutput(String text){

        textOutput.setText(text);
    }

    public class SortAlgorithm extends Thread {
        boolean paused = false;
        int num[];

        public void togglePaused(){
            if (paused)
                paused = false;
            else
                paused = true;
        }

        public void setnum(int temp[]) {
            num = temp;
        }


        @Override
        public void run ()
        {
            int n = num.length;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (num[j - 1] > num[j]) {
                        //swap elements

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
                                if (paused) {
                                    try {
                                        Thread.sleep(2000);

                                    } catch (InterruptedException ie) {
                                    }
                                    //while (!step);{
                                    // step = false;

                                }
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
}
