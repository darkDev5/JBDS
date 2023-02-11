package org.darkdev5.lib.jbds.list.string.comparator;

import java.util.Comparator;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class StringListLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
            return 0;
        } else if (o1.length() > o2.length()) {
            return 1;
        }

        return -1;
    }
}
