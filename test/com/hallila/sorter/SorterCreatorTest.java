package com.hallila.sorter;

import com.hallila.sorter.Sorter;
import com.hallila.sorter.SorterCreator;
import com.hallila.sorter.SorterEnum;
import com.hallila.sorter.impl.BubbleSorter;
import com.hallila.sorter.impl.HeapSorter;
import com.hallila.sorter.impl.MergeSorter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SorterCreatorTest {

    @Test
    public void shouldCreateBubbleSorter(){
        Sorter sorter = SorterCreator.newSorter(SorterEnum.BUBBLE);
        assertTrue(sorter instanceof BubbleSorter);
    }

    @Test
    public void shouldCreateHeapSorter(){
        Sorter sorter = SorterCreator.newSorter(SorterEnum.HEAP);
        assertTrue(sorter instanceof HeapSorter);
    }

    @Test
    public void shouldCreateMergeSorter(){
        Sorter sorter = SorterCreator.newSorter(SorterEnum.MERGE);
        assertTrue(sorter instanceof MergeSorter);
    }

}