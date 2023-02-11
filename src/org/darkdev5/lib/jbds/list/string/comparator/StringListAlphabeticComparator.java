package org.darkdev5.lib.jbds.list.string.comparator;

import java.util.Comparator;

/**
 * @author darkDev5
 * @version 1.0
 * @since 17
 */
public class StringListAlphabeticComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
