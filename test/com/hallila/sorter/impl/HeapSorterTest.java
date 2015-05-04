package com.hallila.sorter.impl;

import org.junit.Before;

public class HeapSorterTest extends SorterTest {

    @Before
    public void initSorter(){
        sorter = new HeapSorter();
    }
}