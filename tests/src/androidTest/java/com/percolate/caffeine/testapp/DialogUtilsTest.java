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
        assertNotNull(alertDialog);
        assertTrue(alertDialog.isShowing());
        AlertDialog secondDialog = DialogUtils.quickDialog(getActivity(), "Second Test");
        assertNull(secondDialog);
        final TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        assertEquals("Test Message", textView.getText().toString());
        alertDialog.dismiss();
        assertFalse(alertDialog.isShowing());
        secondDialog = DialogUtils.quickDialog(getActivity(), "Recreate dialog using DialogUtils");
        assertNotNull(secondDialog);
        assertTrue(secondDialog.isShowing());
        secondDialog.dismiss();
        assertFalse(secondDialog.isShowing());
    }
}
