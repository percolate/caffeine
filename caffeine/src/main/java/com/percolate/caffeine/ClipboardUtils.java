package com.percolate.caffeine;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * Utility methods for using the device clipboard.
 */
public class ClipboardUtils {

    /**
     * Get the current text from the clipboard.
     *
     * @return Clipboard text or {@code null} if clipboard is empty or unavailable.
     */
    public static String getClipboardText(final Context context) {
        final ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        final ClipData clipData = clipboard.getPrimaryClip();
        if(clipData != null && clipData.getItemCount() > 0) {
            final CharSequence clipboardText = clipData.getItemAt(0).getText();
            if(clipboardText != null) {
                return clipboardText.toString();
            }
        }
        return null;
    }

    /**
     * Set the clipboard text.
     *
     * @param text Text to put in the clipboard.
     */
    public static void setClipboardText(final Context context, final String text) {
        if(text != null) {
            final ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            final ClipData clipData = ClipData.newPlainText(text, text);
            clipboard.setPrimaryClip(clipData);
        }
    }
}
