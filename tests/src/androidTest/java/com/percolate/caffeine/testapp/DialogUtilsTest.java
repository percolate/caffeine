package com.percolate.caffeine.testapp;

import android.app.AlertDialog;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.percolate.caffeine.DialogUtils;

public class DialogUtilsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public DialogUtilsTest() {
        super(MainActivity.class);
    }

    public void testQuickDialog(){
        AlertDialog alertDialog = DialogUtils.quickDialog(getActivity(), "Test Message");
        assertTrue(alertDialog.isShowing());
        final TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        assertEquals("Test Message", textView.getText().toString());
        alertDialog.dismiss();
        assertFalse(alertDialog.isShowing());
    }
}
