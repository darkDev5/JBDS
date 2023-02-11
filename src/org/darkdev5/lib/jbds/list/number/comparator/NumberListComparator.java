package org.darkdev5.lib.jbds.list.number.comparator;

import java.util.Comparator;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class NumberListComparator implements Comparator<Number> {
    private boolean reverseSort;

    public NumberListComparator(boolean reverseSort) {
        this.reverseSort = reverseSort;
    }

    @Override
    public int compare(Number o1, Number o2) {
        double o1Value = o1.doubleValue(), o2Value = o2.doubleValue();

        if (o1Value == o2Value) {
            return 0;
        }

        if (reverseSort) {
            if (o1Value > o2Value) {
                return -1;
            }

            return 1;
        } else {
            if (o1Value > o2Value) {
                return 1;
            }

            return -1;
        }
    }


}
