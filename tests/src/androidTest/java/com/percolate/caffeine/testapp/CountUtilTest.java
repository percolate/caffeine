package com.percolate.caffeine.testapp;

import android.util.Log;

import com.percolate.caffeine.CountUtil;

import junit.framework.TestCase;

import java.util.Locale;

public class CountUtilTest extends TestCase {
    private Locale originalLocale = null;

    public void setUp() {
        /* This test setup avoids test failures caused by non-English locales that use different
         * punctuation. For instance, in German, numbers would look like 123.456.789,10 rather than
         * 123,456,789.10. As this test case implies the English locale for assertions, every test
         * will be conducted using the English locale (Locale.ENGLISH) instead and restore the
         * original locale during tearDown.
         */

        Locale currentLocale = Locale.getDefault();
        if (currentLocale != Locale.ENGLISH) {
            Log.i("CountUtilTest", "Setting locale to English");
            Locale.setDefault(Locale.ENGLISH);
            originalLocale = currentLocale;
        }
    }

    public void tearDown() {
        if (originalLocale != null) {
            Log.i("CountUtilTest", "Restoring locale to " + originalLocale.getDisplayName());
            Locale.setDefault(originalLocale);
        }
    }

    public void testGetFormattedCountInt(){
        assertEquals("0", CountUtil.getFormattedCount(0));
        assertEquals("10", CountUtil.getFormattedCount(10));
        assertEquals("100", CountUtil.getFormattedCount(100));
        assertEquals("1k", CountUtil.getFormattedCount(1000));
        assertEquals("10k", CountUtil.getFormattedCount(10000));
        assertEquals("100k", CountUtil.getFormattedCount(100000));
        assertEquals("1m", CountUtil.getFormattedCount(1000000));
        assertEquals("10m", CountUtil.getFormattedCount(10000000));
        assertEquals("100m", CountUtil.getFormattedCount(100000000));
        assertEquals("1b", CountUtil.getFormattedCount(1000000000));

        assertEquals("0", CountUtil.getFormattedCount(0));
        assertEquals("12", CountUtil.getFormattedCount(12));
        assertEquals("129", CountUtil.getFormattedCount(129));
        assertEquals("1.2k", CountUtil.getFormattedCount(1209));
        assertEquals("12k", CountUtil.getFormattedCount(12009));
        assertEquals("120k", CountUtil.getFormattedCount(120009));
        assertEquals("1.2m", CountUtil.getFormattedCount(1200009));
        assertEquals("12m", CountUtil.getFormattedCount(12000009));
        assertEquals("120m", CountUtil.getFormattedCount(120000009));
        assertEquals("1.2b", CountUtil.getFormattedCount(1200000009));
    }

    public void testGetFormattedCountString(){
        assertEquals("0", CountUtil.getFormattedCount("0"));
        assertEquals("10", CountUtil.getFormattedCount("10"));
        assertEquals("100", CountUtil.getFormattedCount("100"));
        assertEquals("1k", CountUtil.getFormattedCount("1000"));
        assertEquals("10k", CountUtil.getFormattedCount("10000"));
        assertEquals("100k", CountUtil.getFormattedCount("100000"));
        assertEquals("1m", CountUtil.getFormattedCount("1000000"));
        assertEquals("10m", CountUtil.getFormattedCount("10000000"));
        assertEquals("100m", CountUtil.getFormattedCount("100000000"));
        assertEquals("1b", CountUtil.getFormattedCount("1000000000"));

        assertEquals("0", CountUtil.getFormattedCount("0"));
        assertEquals("12", CountUtil.getFormattedCount("12"));
        assertEquals("129", CountUtil.getFormattedCount("129"));
        assertEquals("1.2k", CountUtil.getFormattedCount("1209"));
        assertEquals("12k", CountUtil.getFormattedCount("12009"));
        assertEquals("120k", CountUtil.getFormattedCount("120009"));
        assertEquals("1.2m", CountUtil.getFormattedCount("1200009"));
        assertEquals("12m", CountUtil.getFormattedCount("12000009"));
        assertEquals("120m", CountUtil.getFormattedCount("120000009"));
        assertEquals("1.2b", CountUtil.getFormattedCount("1200000009"));
    }

    public void testGetFormattedCountLong(){
        assertEquals("0", CountUtil.getFormattedCount(0L));
        assertEquals("10", CountUtil.getFormattedCount(10L));
        assertEquals("100", CountUtil.getFormattedCount(100L));
        assertEquals("1k", CountUtil.getFormattedCount(1000L));
        assertEquals("10k", CountUtil.getFormattedCount(10000L));
        assertEquals("100k", CountUtil.getFormattedCount(100000L));
        assertEquals("1m", CountUtil.getFormattedCount(1000000L));
        assertEquals("10m", CountUtil.getFormattedCount(10000000L));
        assertEquals("100m", CountUtil.getFormattedCount(100000000L));
        assertEquals("1b", CountUtil.getFormattedCount(1000000000L));

        assertEquals("0", CountUtil.getFormattedCount(0L));
        assertEquals("12", CountUtil.getFormattedCount(12L));
        assertEquals("129", CountUtil.getFormattedCount(129L));
        assertEquals("1.2k", CountUtil.getFormattedCount(1209L));
        assertEquals("12k", CountUtil.getFormattedCount(12009L));
        assertEquals("120k", CountUtil.getFormattedCount(120009L));
        assertEquals("1.2m", CountUtil.getFormattedCount(1200009L));
        assertEquals("12m", CountUtil.getFormattedCount(12000009L));
        assertEquals("120m", CountUtil.getFormattedCount(120000009L));
        assertEquals("1.2b", CountUtil.getFormattedCount(1200000009L));
        assertEquals("12b", CountUtil.getFormattedCount(12000000009L));
        assertEquals("120b", CountUtil.getFormattedCount(120000000009L));
    }

}
