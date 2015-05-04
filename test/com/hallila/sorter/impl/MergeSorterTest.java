package com.hallila.sorter.impl;

import org.junit.Before;

public class MergeSorterTest extends SorterTest {
    @Before
    public void initSorter() {
        sorter = new MergeSorter();
    }
}