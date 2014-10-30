package com.percolate.caffeine;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.PhoneNumberUtils;
import android.util.DisplayMetrics;
import android.util.Patterns;

/**
 * <h2>A class for toys that do not have a home.</h2>
 * <p/>
 * <h3>Common uses:</h3>
 * <code>MiscUtils.{@link #dpToPx dpToPx}(this, 100);</code> //Returns pixel equivalent of 100dp's (Density-independent pixels)<br />
 * <code>MiscUtils.{@link #getVersionName getVersionName}(this);</code> //"Your App name from manifest"<br />
 * <code>MiscUtils.{@link #getVersionName getVersionName}(this);</code> //"5.4.3" - your app version name from AndroidManifest"<br />
 * <code>MiscUtils.{@link #getVersionCode getVersionCode}(this);</code> //307 - your app version number from AndroidManifest"<br />
 * <code>MiscUtils.{@link #getApplicationName getApplicationName}(this);</code> /"Your App" - your app name from AndroidManifest"<br />
 */
public class MiscUtils {

    /**
     * dip to px conversion.
     *
     * @param context The current Context or Activity that this method is called from
     * @param dp      dips (Density-independent pixels) to convert to pixels.
     * @return value of dp's in pixels for the current screen density.
     */
    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    /**
     * Get the "android:versionName" value from the Manifest file.
     *
     * @param context The current Context or Activity that this method is called from
     * @return the application version string, or "Unknown" if versionName cannot be found for
     * the given context.
     */
    public static String getVersionName(Context context) {
        String versionName;
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            versionName = "Unknown";
        }
        return versionName;
    }

    /**
     * Get the "android:versionCode" value from the Manifest file.
     *
     * @param context The current Context or Activity that this method is called from
     * @return the application version code, or -999 if versionName cannot be found for the given context.
     */
    public static int getVersionCode(Context context) {
        int versionCode;
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            versionCode = -999;
        }
        return versionCode;
    }

    /**
     * Get application name from Manifest file.
     *
     * @param context The current Context or Activity that this method is called from
     * @return application name.
     */
    public static String getApplicationName(Context context) {
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }


    /**
     * Uses androids android.util.Patterns.EMAIL_ADDRESS to check if an email address is valid.
     *
     * @param email Address to check
     * @return true if the <code>email</code> is a valid email address.
     */
    public final static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    /**
     * Uses androids android.telephony.PhoneNumberUtils to check if an phone number is valid.
     *
     * @param number Phone number to check
     * @return true if the <code>number</code> is a valid phone number.
     */
    public final static boolean isValidPhoneNumber(String number) {
        if (number == null) {
            return false;
        } else {
            return PhoneNumberUtils.isGlobalPhoneNumber(number);
        }
    }

    /**
     * Uses androids android.util.Patterns.WEB_URL to check if an url is valid.
     *
     * @param url Address to check
     * @return true if the <code>url</code> is a valid web address.
     */
    public final static boolean isValidURL(String url) {
        if (url == null) {
            return false;
        } else {
            return Patterns.WEB_URL.matcher(url).matches();
        }
    }
}
