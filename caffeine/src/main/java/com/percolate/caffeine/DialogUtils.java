package com.percolate.caffeine;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

/**
 * <h2>Utility methods used to show a quick pop-up dialog.</h2>
 * <p/>
 * <h3>Common uses:</h3>
 * <code>DialogUtils.{@link #quickDialog quickDialog}(this, "Test Message");</code> //Shows an alert dialog
 */
public class DialogUtils {

    /**
     * Show a model dialog box.  The <code>android.app.AlertDialog</code> object is returned so that
     * you can specify an OnDismissListener (or other listeners) if required.
     * <b>Note:</b> show() is already called on the AlertDialog being returned.
     *
     * @param context The current Context or Activity that this method is called from.
     * @param message Message to display in the dialog.
     * @return AlertDialog that is being displayed.
     */
    public static AlertDialog quickDialog(final Activity context, final String message) {
        final SpannableString s = new SpannableString(message); //Make links clickable
        Linkify.addLinks(s, Linkify.ALL);

        Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(s);
        builder.setPositiveButton(android.R.string.ok, closeDialogListener());
        AlertDialog dialog = builder.create();
        dialog.show();

        ((TextView) dialog.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance()); //Make links clickable

        return dialog;
    }

    /**
     * Simple listener event that closes the current dialog event when fired.
     *
     * @return DialogInterface.OnClickListener that can be attached to a button
     */
    public static OnClickListener closeDialogListener() {
        return new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        };
    }

}
