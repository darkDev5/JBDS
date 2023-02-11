package org.darkdev5.lib.jbds.utils;

import java.math.BigDecimal;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class NumberUtils {

    /**
     * Check to see if a number is even or odd.
     *
     * @param input The number you want to check.
     * @return Returns true if number is even and false if odd.
     */
    public static boolean isEven(double input) {
        return input % 2 == 0;
    }

    /**
     * Check to see if a number is even or odd.
     *
     * @param input The number you want to check.
     * @return Returns true if number is odd and false if even.
     */
    public static boolean isOdd(double input) {
        return input % 2 != 0;
    }

    /**
     * Check to see if a number is perfect or not.
     *
     * @param number The number you want to check;
     * @return Returns true if number is perfect and false if not.
     */
    public static boolean isPerfect(double number) {
        double sum = 1;

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                if (i * i != number)
                    sum = sum + i + number / i;
                else
                    sum = sum + i;
            }
        }

        return sum == number && number != 1;
    }

    /**
     * Check to see if a number is prime or not.
     *
     * @param number The input number you want to check if it is prime or not.
     * @return Returns true if number is prime and false if not.
     */
    public static boolean isPrime(double number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
