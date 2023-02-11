package org.darkdev5.lib.jbds.list.number;

import org.darkdev5.lib.jbds.list.number.comparator.NumberListComparator;
import org.darkdev5.lib.jbds.list.number.options.NumberOperation;
import org.darkdev5.lib.jbds.list.number.options.NumberSortType;
import org.darkdev5.lib.jbds.list.number.options.NumberType;
import org.darkdev5.lib.jbds.utils.NumberUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @param <E> Only can store numbers.
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class NumberList<E extends Number> implements Iterable<E>, Serializable {
    private final List<Number> numbers;
    private int index;

    public NumberList() {
        numbers = new ArrayList<>();
        index = 0;
    }

    /**
     * Add new number to the end of the list.
     *
     * @param number The number you want to add to the list.
     */
    public void add(Number number) {
        numbers.add(number);
    }

    /**
     * Removes a number from the list.
     *
     * @param number The number you want to remove from list.
     */
    public void remove(Number number) {
        numbers.remove(number);
    }

    /**
     * Get a number from list by its index
     *
     * @param index The position of number element in the list.
     * @return The number found in that index.
     */
    public Number get(int index) {
        return numbers.get(index);
    }

    /**
     * Change a number in the list.
     *
     * @param index  The position of number element in the list.
     * @param number The new value you want to re-initialize.
     */
    public void set(int index, Number number) {
        numbers.set(index, number);
    }

    /**
     * Searchs the list and tell you if the element is in the list or not.
     *
     * @param number The number you want to search in the list.
     * @return Returns true if number found and false if not.
     */
    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    /**
     * Check to see if the list is empty or not.
     *
     * @return Returns true if list is empty and false if not.
     */
    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    /**
     * Clears the entire list.
     */
    public void clear() {
        numbers.clear();
    }

    /**
     * Gets the number of elements in the list.
     *
     * @return Returns the size of elements in the list.
     */
    public int size() {
        return numbers.size();
    }

    /**
     * Sort the entire list by custom comparator.
     *
     * @param comparator Determines how to sort the numbers list.
     */
    public void sort(Comparator<Number> comparator) {
        numbers.sort(comparator);
    }

    /**
     * Get the index of an element in the list.
     * If it's not found it will return -1;
     *
     * @param number The element you want to search and find its index.
     * @return The index of the element in the list.
     */
    public int indexOf(Number number) {
        return numbers.indexOf(number);
    }

    /**
     * Pack entire list intro a number array.
     *
     * @return The array of number instead of list.
     */
    public Number[] toArray() {
        return numbers.toArray(Number[]::new);
    }

    /**
     * Counts the duplicate number in list with exact value of the key.
     *
     * @param key The key you want to count it's duplicate.
     * @return The number of duplicate elements in the list.
     */
    public long countDuplicates(Number key) {
        return numbers.stream()
                .filter(x -> x.equals(key))
                .count();
    }

    /**
     * Removes all duplicate numbers from list.
     * The order of numbers are the same before removing duplicates.
     */
    public void removeDuplicates() {
        List<Number> tmpList = new ArrayList<>();

        for (Number number : numbers) {
            if (!tmpList.contains(number)) {
                tmpList.add(number);
            }
        }

        numbers.clear();
        numbers.addAll(tmpList);
    }

    /**
     * Reverse entire list.
     */
    public void reverse() {
        Collections.reverse(numbers);
    }

    /**
     * Perform 4 main number operations on the list including power.
     *
     * @param operation The operation type you want to perform on the list.
     * @param value     The value you want to perform operation with.
     */
    public void performOperation(NumberOperation operation, Number value) {
        for (int i = 0; i < numbers.size(); i++) {
            Number currentValue = numbers.get(i);

            switch (operation) {
                case Sum -> numbers.set(i, currentValue.doubleValue() + value.doubleValue());
                case Subtract -> numbers.set(i, currentValue.doubleValue() - value.doubleValue());
                case Multiply -> numbers.set(i, currentValue.doubleValue() * value.doubleValue());
                case Divide -> numbers.set(i, currentValue.doubleValue() / value.doubleValue());
                case Pow -> numbers.set(i, Math.pow(currentValue.doubleValue(), value.doubleValue()));
            }
        }
    }

    /**
     * Returns different numbers depends on type of number you want to use.
     * Types are even,odd,perfect and prime numbers.
     * You can select these types and get the numbers you want.
     *
     * @param numberType The type of number you want.
     * @return The numbers you asked will return.
     */
    public List<Number> receiveNumbers(NumberType numberType) {
        return switch (numberType) {
            case Even -> {
                yield numbers.stream()
                        .filter(x -> x.doubleValue() % 2 == 0)
                        .toList();
            }

            case Odd -> {
                yield numbers.stream()
                        .filter(x -> x.doubleValue() % 2 != 0)
                        .toList();
            }

            case Prime -> {
                yield numbers.stream()
                        .filter(x -> NumberUtils.isPrime(x.doubleValue()))
                        .toList();
            }

            case Perfect -> {
                yield numbers.stream()
                        .filter(x -> NumberUtils.isPerfect(x.doubleValue()))
                        .toList();
            }

            default -> null;
        };
    }

    /**
     * Get the biggest number in the list.
     *
     * @return Biggest number in the list.
     */
    public Number biggest() {
        return numbers.stream()
                .max(Comparator.comparingDouble(Number::doubleValue))
                .get();
    }

    /**
     * Get the smallest number in the list.
     *
     * @return The smallest number in the list.
     */
    public Number smallest() {
        return numbers.stream()
                .min(Comparator.comparingDouble(Number::doubleValue))
                .get();
    }

    /**
     * Get the biggest number element position in the list.
     *
     * @return The biggest number element position in the list.
     */
    public int biggestIndex() {
        return numbers.indexOf(
                numbers.stream()
                        .max(Comparator.comparingDouble(Number::doubleValue))
                        .get()
        );
    }

    /**
     * Get the smallest number element position in the list.
     *
     * @return The smallest number element position in the list.
     */
    public int smallestIndex() {
        return numbers.indexOf(
                numbers.stream()
                        .min(Comparator.comparingDouble(Number::doubleValue))
                        .get()
        );
    }

    /**
     * You can select numbers between two ranges.
     * Select start and end position to separate numbers from list.
     *
     * @param start    The start range;
     * @param end      The end range.
     * @param sortType You can set sort type to ascending or descending oder.
     * @return The separated numbers from the list.
     */
    public List<Number> inRangeOf(Number start, Number end, NumberSortType sortType) {
        List<Number> inRangeNumbers = new ArrayList<>();

        for (Number currentValue : numbers) {
            if (currentValue.doubleValue() >= start.doubleValue() &&
                    currentValue.doubleValue() <= end.doubleValue()) {
                inRangeNumbers.add(currentValue);
            }
        }

        switch (sortType) {
            case Ascending -> inRangeNumbers.sort(new NumberListComparator(false));
            case Descending -> inRangeNumbers.sort(new NumberListComparator(true));
        }

        return inRangeNumbers;
    }

    /**
     * Print entire list to the console screen,
     *
     * @param showNumber Enable this if you want to have line numbers.
     * @param nextLine   Go to next line or continue the print in the same line.
     */
    public void printToConsole(boolean showNumber, boolean nextLine) {
        for (int i = 0; i < numbers.size(); i++) {
            if (showNumber) {
                System.out.printf("[%d]: ", i + 1);
            }

            System.out.print(numbers.get(i).doubleValue());

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

        List<Number> firstList = Arrays.asList(((NumberList<?>) obj).toArray()),
                secondList = Arrays.asList(toArray());

        if (firstList.size() != secondList.size()) {
            return false;
        }

        for (Number n : firstList) {
            if (!secondList.contains(n)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));

            if ((i + 1) < numbers.size()) {
                sb.append(" , ");
            }
        }

        return sb.append("]").toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < numbers.size();
            }

            @Override
            public E next() {
                return (E) numbers.get(index++);
            }
        };
    }


}
