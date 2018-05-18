package com.example.fikil.finalbubblesort;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by fikil on 2018-04-30.
 */

public class SortAlgorithm extends Thread {

    volatile boolean paused = false;
    volatile boolean stepWanted = false;
    int[] num = new int[15];
    String result = "";
    ButtonControllerInterface buttonController;

    public void setButtonController(ButtonControllerInterface ButtonController) {
        buttonController = ButtonController;
    }

    public String accessFiles(Context context) {
        // Accessing the testcase file
        InputStream dataSetFileInputStream = context.getResources().openRawResource(R.raw.test_case_4);
        Scanner scanner = new Scanner(dataSetFileInputStream);

        for (int i = 0; i < num.length; i++) {  //initialize the array
            num[i] = scanner.nextInt();
        }

        try {
            dataSetFileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        for (int k = 0; k < num.length; k++) {
            result += num[k] + " ";
        }

        return result;
    }

    public void toggleStep() {
        stepWanted = true;
    }

    public void togglePaused() {

        if (paused) {
            paused = false;
        } else
            paused = true;
    }

    @Override
    public void run() { // this method is implements the bubble sort algorithm

        int n = num.length;
        int temp = 0;
        for (int i = 0; i < n; i++) { // start the first 'for' loop
            for (int j = 1; j < (n - i); j++) { //start the seconds 'for' loop
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


                    while (paused) {
                        if (stepWanted) {
                            stepWanted = false;
                            break;
                        }
                    }

                    try {   //Takes one second for each swap, as a result the UI shows a progression and not a flash.
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        return;
                    }
                    buttonController.update(result);

                }
            }
        }
    }
}


