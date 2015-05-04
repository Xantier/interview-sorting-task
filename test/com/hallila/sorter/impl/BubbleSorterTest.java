package com.hallila.sorter.impl;

import org.junit.Before;

public class BubbleSorterTest extends SorterTest {

    @Before
    public void initSorter(){
        sorter = new BubbleSorter();
    }
}