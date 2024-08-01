
package com.springbloom.SpringBloom.util;

import java.text.DecimalFormat;

/**
 *
 * @author mrRobot
 */
public class FormatUtil {
    public static String formatCurrency(Double value) {
        if (value == null) {
            return "$0.00";
        }
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return df.format(value);
    }
}