package com.hallila.sorter;

import com.hallila.sorter.impl.BubbleSorter;
import com.hallila.sorter.impl.HeapSorter;
import com.hallila.sorter.impl.MergeSorter;

/**
 * Created by jussi on 08/05/14.
 */
public enum SorterEnum {
    BUBBLE(BubbleSorter.class),
    MERGE(MergeSorter.class),
    HEAP(HeapSorter.class);

    private Class clazz;

    SorterEnum(Class clazz){
        this.clazz = clazz;
    }

    Class getSorterClass(){
        return clazz;
    }

}
