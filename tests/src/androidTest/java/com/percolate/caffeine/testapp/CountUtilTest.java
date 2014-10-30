package com.percolate.caffeine.testapp;

import com.percolate.caffeine.CountUtil;

import junit.framework.TestCase;

public class CountUtilTest extends TestCase {

    public void testGetFormattedCountInt() {
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

    public void testGetFormattedCountString() {
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

    public void testGetFormattedCountLong() {
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
