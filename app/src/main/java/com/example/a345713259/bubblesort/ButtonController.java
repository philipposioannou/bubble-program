package com.example.fikil.finalbubblesort;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fikil on 2018-04-26.
 */
public class ButtonController implements ButtonControllerInterface {
    MainActivityInterface mainActivity;
    SortAlgorithm sortThread = new SortAlgorithm();

    public void setMainActivity(MainActivityInterface MainActivity) {
        mainActivity = MainActivity;

    }

    public void update(String Result) {
        //update textOutput
        mainActivity.update(Result);
    }


    public void firsttimestartPauseButtonClick(Context context) {
        //read text file, start sort thread
        sortThread.accessFiles((Context) mainActivity);
        sortThread.setButtonController(this);
        sortThread.start();
    }

    public void notFirsttimestartPauseButtonClick() {
        sortThread.togglePaused();
    }

    public void stepButtonOnClick() {
        sortThread.toggleStep();
    }

    public void resetButtonOnClick(Context context) {
        //interrupt old sortThread, initialize new one, access files again
        sortThread.interrupt();
        sortThread = new SortAlgorithm();
        sortThread.accessFiles(context);
    }

}


