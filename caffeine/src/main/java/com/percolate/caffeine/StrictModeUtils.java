package com.percolate.caffeine;

import android.os.StrictMode;

/**
 * <h2>Used to turn on strict mode for Dev builds</h2>
 * <p/>
 * <h3>Common uses:</h3>
 * <code>StrictModeUtils.{@link #enableStrictModeForDevRelease enableStrictModeForDevRelease}();</code><br />
 * <p/>
 * After calling this method, the screen will flash if any of the following occur:
 * <ul>
 * <li>Disk reads on the UI thread</li>
 * <li>Disk writes on the UI thread</li>
 * <li>Disk network calls on the UI thread</li>
 * </ul>
 */
public class StrictModeUtils {

    /**
     * Turn on Strict Mode options.  Good idea for dev builds.
     * <p/>
     * See: http://developer.android.com/reference/android/os/StrictMode.html
     */
    public static void enableStrictModeForDevRelease() {
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder()
                        .detectDiskReads()
                        .detectDiskWrites()
                        .detectNetwork()
                        .penaltyFlashScreen()
                        .build()
        );

    }
}
