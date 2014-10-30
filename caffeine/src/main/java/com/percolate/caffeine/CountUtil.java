package com.percolate.caffeine;

import java.text.DecimalFormat;

/**
 * <h2>Utility methods for formatting counts</h2>
 * <p/>
 * <h3>Common uses:</h3>
 * <code>CountUtil.{@link #getFormattedCount getFormattedCount}(1200000);</code> // returns &quot;1.2m&quot;<br />
 */

public class CountUtil {

    /**
     * @see #getFormattedCount(Long)
     */
    public static String getFormattedCount(int count) {
        return getFormattedCount(Long.valueOf(count));
    }

    /**
     * @see #getFormattedCount(Long)
     */
    public static String getFormattedCount(String count) {
        return getFormattedCount(Long.parseLong(count));
    }

    /**
     * Used to format a given number into a short representation.
     * <p/>
     * Examples:
     * Given 9100, will return "9.1k".
     * Given 8100000, will return "8.1m"
     * Given 10, will return 10"
     *
     * @param count Value to convert.
     * @return Formatted value (see examples)
     */
    public static String getFormattedCount(Long count) {
        final String unit;
        final Double dbl;
        final DecimalFormat format = new DecimalFormat("#.#");
        if (count < 1000) {
            return format.format(count);
        } else if (count < 1000000) {
            unit = "k";
            dbl = count / 1000.0;
        } else if (count < 1000000000) {
            unit = "m";
            dbl = count / 1000000.0;
        } else {
            unit = "b";
            dbl = count / 1000000000.0;
        }
        return format.format(dbl) + unit;
    }
}
