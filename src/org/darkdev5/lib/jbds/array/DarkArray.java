package org.darkdev5.lib.jbds.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class DarkArray {

    /**
     * Get an array and count keys in the array.
     *
     * @param array The input array you want to search.
     * @param key   The key to find in the array.
     * @param <E>   Uses generics to pass any type of array.
     * @return Returns the number of keys found in the array.
     */
    public static <E> long count(E[] array, E key) {
        return Arrays.stream(array)
                .filter(item -> item.equals(key))
                .count();
    }
}
