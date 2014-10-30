package com.percolate.caffeine;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

/**
 * <h2>Common phone utility methods</h2>
 * <p/>
 * <h3>Common uses:</h3>
 * <code>PhoneUtils.{@link #isRotationEnabled isRotationEnabled}(this);</code><br />
 * <code>PhoneUtils.{@link #isNetworkAvailable isNetworkAvailable}(this);</code><br />
 * <code>PhoneUtils.{@link #isConnectedWifi isConnectedWifi}(this);</code><br />
 * <code>PhoneUtils.{@link #isConnectedMobile isConnectedMobile}(this);</code><br />
 */
public class PhoneUtils {

    /**
     * Checks to see if the user has rotation enabled/disabled in their phone settings.
     *
     * @param context The current Context or Activity that this method is called from
     * @return true if rotation is enabled, otherwise false.
     */
    public static boolean isRotationEnabled(Context context) {
        return android.provider.Settings.System.getInt(context.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0) == 1;
    }

    /**
     * Checks to see if the device is connected to a network (cell, wifi, etc).
     *
     * @param context The current Context or Activity that this method is called from
     * @return true if a network connection is available, otherwise false.
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Check if there is any connectivity to a Wifi network.
     * <p/>
     * Can be used in combination with {@link #isConnectedMobile}
     * to provide different features if the device is on a wifi network or a cell network.
     *
     * @param context The current Context or Activity that this method is called from
     * @return true if a wifi connection is available, otherwise false.
     */
    public static boolean isConnectedWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    /**
     * Check if there is any connectivity to a mobile network
     * <p/>
     * Can be used in combination with {@link #isConnectedWifi}
     * to provide different features if the device is on a wifi network or a cell network.
     *
     * @param context The current Context or Activity that this method is called from
     * @return true if a mobile connection is available, otherwise false.
     */
    public static boolean isConnectedMobile(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }

}
