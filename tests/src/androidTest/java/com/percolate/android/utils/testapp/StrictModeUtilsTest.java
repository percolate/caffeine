package com.percolate.android.utils.testapp;

import android.os.StrictMode;
import android.test.ActivityInstrumentationTestCase2;

import com.percolate.android.utils.StrictModeUtils;

public class StrictModeUtilsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public StrictModeUtilsTest() {
        super(MainActivity.class);
    }

    public void testEnableStrictModeForDevRelease(){
        StrictModeUtils.enableStrictModeForDevRelease();
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        //No way to test this, uses masks that we don't have access to.
        //Is is to make sure no crashes occur.
    }
}
