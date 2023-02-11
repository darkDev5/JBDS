package org.darkdev5.lib.jbds.list.string;

import java.io.Serializable;
import java.util.*;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class StringList implements Iterable<String>, Serializable {
    private final List<String> strings;
    private int index;

    public StringList() {
        strings = new ArrayList<>();
        index = 0;
    }

    /**
     * Add new String to the end of the list.
     *
     * @param input The input you want to add to the list.
     */
    public void add(Object input) {
        strings.add(input.toString());
    }

    /**
     * Removes a String from the list.
     *
     * @param input The String you want to remove from the list.
     */
    public void remove(Object input) {
        strings.remove(input.toString());
    }

    /**
     * Get a String in the list from its position.
     *
     * @param index The position of the String in the list.
     * @return The String found in that position in the list.
     */
    public String get(int index) {
        return strings.get(index);
    }

    /**
     * Change a String in the list by its position.
     *
     * @param index The position of String element in the list.
     * @param value The new value you want to set for that String.
     */
    public void set(int index, Object value) {
        strings.set(index, value.toString());
    }

    /**
     * Check the list to see if this value exists in the list or not.
     *
     * @param input The value you want to search in the list.
     * @return Returns true if value found and false if not.
     */
    public boolean contains(Object input) {
        return strings.contains(input.toString());
    }

    /**
     * Check the list to see if the list is empty or not.
     *
     * @return Returns true if the list was empty and false if not.
     */
    public boolean isEmpty() {
        return strings.isEmpty();
    }

    /**
     * Clears the entire list.
     */
    public void clear() {
        strings.clear();
    }

    /**
     * Get the number of elements present in the list.
     *
     * @return The size of the entire list.
     */
    public int size() {
        return strings.size();
    }

    /**
     * Sort entire list by custom comparator.
     *
     * @param comparator Determines how to sort the entire list.
     */
    public void sort(Comparator<String> comparator) {
        strings.sort(comparator);
    }

    /**
     * Returns the position of the element in the list.
     *
     * @param input The value you want to check and get its position.
     * @return The position of that element in the list.
     */
    public int indexOf(Object input) {
        return strings.indexOf(input.toString());
    }

    /**
     * Convert entire list to a String array.
     *
     * @return The converted list to the array will be return.
     */
    public String[] toArray() {
        return strings.toArray(String[]::new);
    }

    /**
     * Count duplicate Strings in the list.
     *
     * @param key The key you want to search in the list.
     * @return The number of duplicate elements in the list.
     */
    public long countDuplicates(String key) {
        return strings.stream()
                .filter(str -> str.equals(key))
                .count();
    }

    /**
     * Removes all duplicate Strings in the list.
     * The order of elements are the same before removing duplicates.
     */
    public void removeDuplicates() {
        List<String> tmpList = new ArrayList<>();

        for (String string : strings) {
            if (!tmpList.contains(string)) {
                tmpList.add(string);
            }
        }

        strings.clear();
        strings.addAll(tmpList);
    }

    /**
     * Reverse entire list.
     */
    public void reverse() {
        Collections.reverse(strings);
    }

    /**
     * Get the biggest String by length in the entire list.
     *
     * @return The biggest String in the list.
     */
    public String biggest() {
        return strings.stream().max(Comparator.comparingInt(String::length)).get();
    }

    /**
     * Get the smallest String by length in the entire list.
     *
     * @return The snallest String in the list.
     */
    public String smallest() {
        return strings.stream().min(Comparator.comparingInt(String::length)).get();
    }

    /**
     * Get the biggest String element position in the list.
     *
     * @return The biggest String position in the list.
     */
    public int biggestIndex() {
        return strings.indexOf(strings.stream().max(Comparator.comparingInt(String::length)).get());
    }

    /**
     * Get the smallest String element position in the list.
     *
     * @return The smallest String position in the list.
     */
    public int smallestIndex() {
        return strings.indexOf(strings.stream().min(Comparator.comparingInt(String::length)).get());
    }

    /**
     * Convert all the Strings in the list to lower case.
     */
    public void toLowerCase() {
        strings.replaceAll(String::toLowerCase);
    }

    /**
     * Convert all the Strings in the list to upper case.
     */
    public void toUpperCase() {
        strings.replaceAll(String::toUpperCase);
    }

    /**
     * Concat new value to all elements in the list.
     *
     * @param input The new value you want to concat to the elements of the list.
     */
    public void concat(Object input) {
        strings.replaceAll(s -> s.concat(input.toString()));
    }

    /**
     * Concat new value to specific element in the list.
     *
     * @param index The position of the element you want to change its value.
     * @param input The new value you want to concat to the specific element in the list.
     */
    public void concat(int index, Object input) {
        strings.set(index, strings.get(index).concat(input.toString()));
    }

    /**
     * Capitalize the entire list elements.
     */
    public void capitalize() {
        for (int i = 0; i < strings.size(); i++) {
            String currentValue = strings.get(i);

            if (currentValue.length() > 0) {
                strings.set(i, String.valueOf(currentValue.charAt(0)).toUpperCase()
                        .concat(currentValue.substring(1)));
            }
        }
    }

    /**
     * Decapitalize the entire list elements.
     */
    public void deCapitalize() {
        for (int i = 0; i < strings.size(); i++) {
            String currentValue = strings.get(i);

            if (currentValue.length() > 0) {
                strings.set(i, String.valueOf(currentValue.charAt(0)).toLowerCase()
                        .concat(currentValue.substring(1)));
            }
        }
    }

    /**
     * Print entire list to the console screen,
     *
     * @param showNumber Enable this if you want to have line numbers.
     * @param nextLine   Go to next line or continue the print in the same line.
     */
    public void printToConsole(boolean showNumber, boolean nextLine) {
        for (int i = 0; i < strings.size(); i++) {
            if (showNumber) {
                System.out.printf("[%d]: ", i + 1);
            }

            System.out.print(strings.get(i));

            if (nextLine) {
                System.out.println();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }

        String[] firstArray = ((StringList) obj).toArray(), secondArray = toArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < strings.size(); i++) {
            sb.append(strings.get(i));

            if ((i + 1) < strings.size()) {
                sb.append(",");
            }
        }

        return sb.append("]").toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < strings.size();
            }

            @Override
            public String next() {
                return strings.get(index++);
            }
        };
    }

}
