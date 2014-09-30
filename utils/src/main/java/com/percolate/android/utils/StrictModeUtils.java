package com.percolate.android.utils;

import android.os.StrictMode;

/**
 * <h2>Used to turn on strict mode for Dev builds</h2>
 */
public class StrictModeUtils {

	/**
	 * Turn on Strict Mode options.  Good idea for dev builds.
     *
     * See: http://developer.android.com/reference/android/os/StrictMode.html
     *
	 */
	public static void enableStrictModeForDevRelease(){
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
