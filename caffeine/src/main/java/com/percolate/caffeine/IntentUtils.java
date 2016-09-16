package com.percolate.caffeine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Utility methods for starting various kinds of system {@link android.content.Intent}'s.
 */
public class IntentUtils {

    /**
     * Return an OnClickListener that will open a web browser for the given <code>url</code>.
     */
    public static OnClickListener launchWebBrowserOnClick(final Context context, final String url){
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWebBrowser(context, url);
            }
        };
    }

    /**
     * Start Intent to launch web browser.
     */
    public static void launchWebBrowser(final Context context, final String url) {
        if (context != null && url != null && !"".equals(url)) {
            final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            if (browserIntent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(browserIntent);
            } else {
                ToastUtils.quickToast(context, "Sorry, Could not open the link. You do not have an application installed to open it.");
                Log.e("Caffeine", "Failed to open link, because an application is not available to view it.");
            }
        } else {
            ToastUtils.quickToast(context, "Sorry, Could not open link.  No URL provided.");
        }
    }

    /**
     * Check if app for the given package name is installed on this device.
     */
    public static boolean isAppInstalled(final Context context, final String packageName){
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Launch camera on the device using android's ACTION_IMAGE_CAPTURE intent.
     * @param outputDestination Save image to this location.
     */
    public static void launchCameraIntent(final Activity context, final Uri outputDestination, final int requestCode){
        final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputDestination);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivityForResult(intent, requestCode);
        }
    }

    /**
     * Tries to launch the application for a given package name.
     * @return true if launch succeeded, otherwise false.
     */
    public static boolean launchAppForPackage(final Context context, final String packageName) {
        try {
            final PackageManager packageManager = context.getPackageManager();
            final Intent intent = packageManager.getLaunchIntentForPackage(packageName);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(intent);
            return true;
        } catch (Exception ex) {
            Log.e("Caffeine", "Failed to launch application for package name [" + packageName + "]", ex);
            return false;
        }
    }

    /**
     * Starts a {@code ACTION_SENDTO} system {@code Intent} used to create a message (email, sms, text, etc).
     * @param subject   Optional subject line.
     * @param body      Optional message body.
     * @param toAddress Optional "to" address.
     */
    public static void sendMessage(final Context context, final String subject, final String body, final String toAddress) {
        final Intent intent;
        if (toAddress != null && !"".equals(toAddress)) {
            intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", toAddress, null));
        } else {
            intent = new Intent(Intent.ACTION_SEND);
        }
        intent.setType("text/plain");
        if (subject != null && !"".equals(subject)) {
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        }
        if (body != null && !"".equals(body)) {
            intent.putExtra(Intent.EXTRA_TEXT, body);
        }
        context.startActivity(Intent.createChooser(intent, "Send message..."));
    }
}
