package com.percolate.caffeine.testapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.percolate.caffeine.ActivityUtils;

public class ActivityUtilsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public ActivityUtilsTest() {
        super(MainActivity.class);
    }

    public void tearDown() throws Exception {
        super.tearDown();
        ActivityTwo.activityStarted = false;
    }

    public void testLaunchActivity() {
        assertNotNull(getActivity());

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ActivityTwo.class.getName(), null, false);
        ActivityUtils.launchActivity(getActivity(), ActivityTwo.class, false);
        Activity activityTwo = activityMonitor.waitForActivity();
        SystemClock.sleep(100);

        assertTrue(ActivityTwo.activityStarted);
        activityTwo.finish();
    }

    public void testLaunchActivity2() {
        assertNotNull(getActivity());

        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ActivityTwo.class.getName(), null, false);
        ActivityUtils.launchActivity(getActivity(), ActivityTwo.class, true);
        Activity activityTwo = activityMonitor.waitForActivity();
        SystemClock.sleep(100);

        assertTrue(ActivityTwo.activityStarted);
        activityTwo.finish();
    }


}
