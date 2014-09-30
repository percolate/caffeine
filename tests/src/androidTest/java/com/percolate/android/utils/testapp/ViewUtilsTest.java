package com.percolate.android.utils.testapp;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.percolate.android.utils.ViewUtils;

public class ViewUtilsTest extends ActivityInstrumentationTestCase2<ViewUtilsActivity> {

    public ViewUtilsTest() {
        super(ViewUtilsActivity.class);
    }

    public void testFindViewByIdSimple() {
        TextView textView1 = ViewUtils.findViewById(getActivity(), R.id.text_view_1);
        TextView textView2 = ViewUtils.findViewById(getActivity(), R.id.text_view_2);

        assertNotNull(textView1);
        assertNotNull(textView2);

        assertEquals("VIEW1", textView1.getTag());
        assertEquals("VIEW2", textView2.getTag());
    }

    public void testFindViewByIdNull() {
        TextView textView1 = ViewUtils.findViewById(getActivity(), R.id.text_view_1);
        TextView textView2 = ViewUtils.findViewById(getActivity(), R.id.activity_two_layout);

        assertNotNull(textView1);
        assertNull(textView2);
    }

    public void testFindViewByIdWrongCast() {
        try {
            ImageView textView = ViewUtils.findViewById(getActivity(), R.id.text_view_1);
            fail("expected textView to throw a ClassCastException" + textView); //expected an exception.  If we get this far the ex was not thrown.
        } catch (ClassCastException ccEx){
            assertTrue("Expected ClassCastException", true);
        }
    }

    public void testFindViewByIdForChildViews() {
        LinearLayout linearLayout = ViewUtils.findViewById(getActivity(), R.id.layout_1);
        TextView textView = ViewUtils.findViewById(linearLayout, R.id.text_view_2);
        assertNotNull(textView);
        assertEquals("VIEW2", textView.getTag());
    }

    public void testFindViewByIdForChildViewsWrongCast() {
        try {
            LinearLayout linearLayout = ViewUtils.findViewById(getActivity(), R.id.layout_1);
            ImageView textView = ViewUtils.findViewById(linearLayout, R.id.text_view_2);
            fail("expected textView to throw a ClassCastException" + textView); //expected an exception.  If we get this far the ex was not thrown.
        } catch (ClassCastException ccEx){
            assertTrue("Expected ClassCastException", true);
        }
    }

    public void testGetText(){
        String text = ViewUtils.getText(getActivity(), R.id.text_view_1);
        assertEquals("Original String 1", text);
    }

    public void testGetTextNullViewReturnsBlank(){
        String text = ViewUtils.getText(getActivity(), R.id.activity_two_layout);
        assertEquals("", text);
    }

    public void testSetText(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ViewUtils.setText(getActivity(), R.id.text_view_1, "New Text");
            }
        });
        getInstrumentation().waitForIdleSync();

        String text = ViewUtils.getText(getActivity(), R.id.text_view_1);
        assertEquals("New Text", text);
    }

    public void testSetTextChildView(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LinearLayout layout = ViewUtils.findViewById(getActivity(), R.id.layout_1);
                ViewUtils.setText(layout, R.id.text_view_2, "New Text");
            }
        });
        getInstrumentation().waitForIdleSync();

        String text = ViewUtils.getText(getActivity(), R.id.text_view_2);
        assertEquals("New Text", text);
    }

    public void testAppendText(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView textView = ViewUtils.findViewById(getActivity(), R.id.text_view_1);
                ViewUtils.appendText(textView, "...Added Text");
            }
        });
        getInstrumentation().waitForIdleSync();

        String text = ViewUtils.getText(getActivity(), R.id.text_view_1);
        assertEquals("Original String 1...Added Text", text);
    }

    public void testHideView(){
        final View textView = ViewUtils.findViewById(getActivity(), R.id.text_view_1);
        assertEquals(View.VISIBLE, textView.getVisibility());

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ViewUtils.hideView(getActivity(), R.id.text_view_1);
            }
        });
        getInstrumentation().waitForIdleSync();

        assertEquals(View.GONE, textView.getVisibility());
    }

    public void testShowView(){
        final View textView = ViewUtils.findViewById(getActivity(), R.id.hidden_view_1);
        assertEquals(View.GONE, textView.getVisibility());

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ViewUtils.showView(getActivity(), R.id.hidden_view_1);
            }
        });
        getInstrumentation().waitForIdleSync();

        assertEquals(View.VISIBLE, textView.getVisibility());
    }

}
