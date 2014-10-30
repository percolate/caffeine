package com.percolate.caffeine.testapp;

import android.test.ActivityInstrumentationTestCase2;

import com.percolate.caffeine.MiscUtils;

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

    public void testIsValidPhoneNumberTrue(){
        assertTrue(MiscUtils.isValidPhoneNumber("636-48018"));
        assertTrue(MiscUtils.isValidPhoneNumber("+1-541-754-3010"));
    }

    public void testIsValidPhoneNumberFalse(){
        assertFalse(MiscUtils.isValidEmail(null));
        assertFalse(MiscUtils.isValidEmail(""));
        assertFalse(MiscUtils.isValidEmail("test"));
        assertFalse(MiscUtils.isValidEmail("636-48018f"));
    }

    public void testIsValidURLTrue(){
        assertTrue(MiscUtils.isValidURL("http://google.com"));
        assertTrue(MiscUtils.isValidURL("https://www.google.com"));
    }

    public void testIsValidURLFalse(){
        assertFalse(MiscUtils.isValidEmail(null));
        assertFalse(MiscUtils.isValidEmail(""));
        assertFalse(MiscUtils.isValidEmail("htttp://google.com"));
        assertFalse(MiscUtils.isValidEmail("google"));
    }
}
