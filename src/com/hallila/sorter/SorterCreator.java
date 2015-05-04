package com.hallila.sorter;

/**
 * Created by jussi on 08/05/14.
 */
public class SorterCreator {

    public static Sorter newSorter(SorterEnum bubble) {
        try {
            return (Sorter) bubble.getSorterClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
