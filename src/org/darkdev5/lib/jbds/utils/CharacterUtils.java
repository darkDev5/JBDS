package org.darkdev5.lib.jbds.utils;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class CharacterUtils {

    /**
     * Converts a character to lowercase.
     *
     * @param input The input character to convert.
     * @return The character will be lowercase, no difference for numbers.
     */
    public static char toLowerCase(char input) {
        return String.valueOf(input).toLowerCase().charAt(0);
    }

    /**
     * Converts a character to uppercase.
     *
     * @param input The input character to convert.
     * @return The character will be uppercase, no difference for numbers.
     */
    public static char toUpperCase(char input) {
        return String.valueOf(input).toUpperCase().charAt(0);
    }

    /**
     * This method gets a character and get its ascii value.
     *
     * @param input The input character you want to get its ascii code.
     * @return The character ascii code will return.
     */
    public static int getAsciiCode(char input) {
        return input;
    }

    /**
     * This method gets a ascii code and convert it to a character from ascii table.
     *
     * @param ascii The character ascii code.
     * @return The return is the character from ascii table.
     */
    public static char getCharacter(int ascii) {
        return (char) ascii;
    }

    /**
     * Check to see if two characters are equals or not.
     * The value of character will check not their ascii code.
     * You can set the equal type to check for case-sensitivity or not.
     *
     * @param first         The first input character.
     * @param second        The second input character.
     * @param caseSensitive If you put case-sensitive to true, it will check upper and lower case, otherwise it doesn't matter.
     * @return True if two characters are equals and false if not.
     */
    public static boolean charactersEqual(char first, char second, boolean caseSensitive) {
        if (caseSensitive) {
            return first == second;
        }

        return String.valueOf(first).equalsIgnoreCase(String.valueOf(second));
    }
}
