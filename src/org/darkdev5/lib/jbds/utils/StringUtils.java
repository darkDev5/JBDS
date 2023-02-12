package org.darkdev5.lib.jbds.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.Arrays;
import java.util.List;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class StringUtils {

    /**
     * Get a String and detect if String is null or empty.
     *
     * @param input The input String you want to check.
     * @return It returns true if String is empty and false if not.
     */
    public static boolean isNullOrEmpty(String input) {
        if (input == null) {
            return true;
        }

        return input.isEmpty();
    }

    /**
     * Get a String and detect if String is null or has empty or only whitespaces.
     *
     * @param input The input String you want to check.
     * @return It returns true if String is empty or only has whitespaces and false if not.
     */
    public static boolean isNullOrBlank(String input) {
        if (input == null) {
            return true;
        }

        return input.isBlank();
    }

    /**
     * You can reverse String with this method.
     *
     * @param input The input String you want to reverse.
     * @return The reversed String.
     */
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * You can check to see if String only contains numbers or not.
     *
     * @param input The input String you want to check.
     * @return Returns true if String contains only numbers and false if not.
     */
    public static boolean isNumber(String input) {
        return org.apache.commons.lang3.StringUtils.isNumeric(input);
    }

    /**
     * You can check to see if String contains numbers or not.
     *
     * @param input The input String you want to check.
     * @return Returns true if String doesn't contain numbers and false if it contains numbers.
     */
    public static boolean isText(String input) {
        return !org.apache.commons.lang3.StringUtils.isNumeric(input);
    }

    /**
     * You can split by character length not by other Strings.
     *
     * @param input             The input String you want to start split.
     * @param length            The length of each substring.
     * @param removeWhiteSpaces If you want to remove all spaces in String set this to true.
     * @return Returns a list of split Strings.
     */
    public static List<String> split(String input, int length, boolean removeWhiteSpaces) {
        if (removeWhiteSpaces) {
            input = input.replace(" ", "");
        }

        return Arrays.asList(Iterables.toArray(Splitter.fixedLength(length).split(input), String.class));
    }
}
