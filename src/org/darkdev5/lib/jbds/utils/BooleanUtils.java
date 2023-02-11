package org.darkdev5.lib.jbds.utils;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class BooleanUtils {

    /**
     * Get a boolean and convert it to the number.
     * If the value is true it returns 1 and if value is false it returns 0.
     *
     * @param input The boolean input you want to convert to the number.
     * @return The converted value from boolean is 1 or 0.
     */
    public static int booleanToNumber(boolean input) {
        return input ? 1 : 0;
    }

    /**
     * This method reverse the boolean input value.
     *
     * @param input The boolean input value you want to reverse.
     * @return The reversed boolean value.
     */
    public static boolean reverseBoolean(boolean input) {
        return !input;
    }
}
