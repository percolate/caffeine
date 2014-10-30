package com.percolate.caffeine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.Map;
import java.util.Map.Entry;

/**
 * <h2>Utility methods for common Activity code</h2>
 * <p/>
 * <h3>Common uses:</h3>
 * <code>ActivityUtils.{@link #launchActivity launchActivity}(this, SomeNewActivity.class);</code><br />
 * <code>ActivityUtils.{@link #launchActivity launchActivity}(this, SomeNewActivity.class, extraParamsMap);</code><br />
 */
public class ActivityUtils {

    /**
     * Launch an Activity.
     *
     * @param context              The current Context or Activity that this method is called from.
     * @param activity             The new Activity to open.
     * @param closeCurrentActivity whether or not the current activity should close.
     * @param params               Parameters to add to the intent as a Bundle.
     */
    public static void launchActivity(Activity context, Class<? extends Activity> activity, boolean closeCurrentActivity, Map<String, String> params) {
        Intent intent = new Intent(context, activity);

        if (params != null) {
            Bundle bundle = new Bundle();
            for (Entry<String, String> param : params.entrySet()) {
                bundle.putString(param.getKey(), param.getValue());
            }
            intent.putExtras(bundle);
        }

        context.startActivity(intent);
        if (closeCurrentActivity) {
            context.finish();
        }
    }

    /**
     * @see com.percolate.caffeine.ActivityUtils#launchActivity(android.app.Activity, Class, boolean, java.util.Map)
     */
    public static void launchActivity(Activity context, Class<? extends Activity> activity, boolean closeCurrentActivity) {
        ActivityUtils.launchActivity(context, activity, closeCurrentActivity, null);
    }

    /**
     * Used to get the parameter values passed into Activity via a Bundle.
     *
     * @return param Parameter value
     */
    public static String getExtraString(Activity context, String key) {
        String param = "";
        Bundle bundle = context.getIntent().getExtras();
        if (bundle != null) {
            param = bundle.getString(key);
        }
        return param;
    }

    /**
     * Used to get the parameter values passed into Activity via a Bundle.
     *
     * @param context The current Context or Activity that this method is called from
     * @param key     Extra key name.
     * @return param Parameter value
     */
    public static Object getExtraObject(Activity context, String key) {
        Object param = null;
        Bundle bundle = context.getIntent().getExtras();
        if (bundle != null) {
            param = bundle.get(key);
        }
        return param;
    }

    /**
     * Force screen to turn on if the phone is asleep.
     *
     * @param context The current Context or Activity that this method is called from
     */
    public static void turnScreenOn(Activity context) {
        try {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        } catch (Exception ex) {
            Log.e("PercolateAndroidUtils", "Unable to turn on screen for activity " + context);
        }
    }

}
