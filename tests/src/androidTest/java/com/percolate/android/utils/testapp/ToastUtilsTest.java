package com.percolate.android.utils.testapp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.percolate.android.utils.ToastUtils;

public class ToastUtilsTest extends ActivityInstrumentationTestCase2<MainActivity>{

    public ToastUtilsTest() {
        super(MainActivity.class);
    }

    public void testQuickToast() {
        Toast toast = ToastUtils.quickToast(getActivity(), "Test Message");
        assertEquals(Toast.LENGTH_SHORT, toast.getDuration());
        TextView view = (TextView) ((LinearLayout) toast.getView()).getChildAt(0);
        assertEquals("Test Message", view.getText().toString());
    }

    public void testQuickToastLong() {
        Toast toast = ToastUtils.quickToast(getActivity(), "Test Message 2", true);
        assertEquals(Toast.LENGTH_LONG, toast.getDuration());
        TextView view = (TextView) ((LinearLayout) toast.getView()).getChildAt(0);
        assertEquals("Test Message 2", view.getText().toString());
    }

}
