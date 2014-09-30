package com.percolate.android.utils.testapp;

import android.test.ActivityInstrumentationTestCase2;

import com.percolate.android.utils.MiscUtils;

public class MiscUtilsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MiscUtilsTest() {
        super(MainActivity.class);
    }

    public void testGetApplicationName(){
        String applicationName = MiscUtils.getApplicationName(getActivity());
        assertEquals("AndroidUtils Unit Tests", applicationName);
    }

    public void testGetVersionName(){
        String versionName = MiscUtils.getVersionName(getActivity());
        assertEquals("5.4.8", versionName);
    }

    public void testGetVersionCode(){
        int versionCode = MiscUtils.getVersionCode(getActivity());
        assertEquals(687, versionCode);
    }

    public void testIsValidEmailTrue(){
        assertTrue(MiscUtils.isValidEmail("test@test.com"));
        assertTrue(MiscUtils.isValidEmail("test_test@test.net"));
        assertTrue(MiscUtils.isValidEmail("t@test.sk.ca"));
        assertTrue(MiscUtils.isValidEmail("t@t.t"));
    }

    public void testIsValidEmailFalse(){
        assertFalse(MiscUtils.isValidEmail("!test@test.com"));
        assertFalse(MiscUtils.isValidEmail("te#st_test@test.net"));
        assertFalse(MiscUtils.isValidEmail("t@te@st.sk.ca"));
        assertFalse(MiscUtils.isValidEmail("test"));
        assertFalse(MiscUtils.isValidEmail(null));
        assertFalse(MiscUtils.isValidEmail(""));
        assertFalse(MiscUtils.isValidEmail("t@t"));
    }

}
