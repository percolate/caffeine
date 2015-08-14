package com.percolate.caffeine.testapp;

import android.app.Activity;
import android.os.Bundle;


public class ActivityTwo extends Activity {

    public transient static boolean activityStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ActivityTwo.activityStarted = true;
    }

}
