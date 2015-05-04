package com.hallila.sorter.impl;

import com.hallila.pojo.Student;
import com.hallila.sorter.Sorter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by jussi on 08/05/14.
 */
public abstract class SorterTest {
    protected Sorter sorter;
    protected List<Student> sortable = new ArrayList<Student>();
    protected List<Student> linearSortable = new ArrayList<Student>();

    @Before
    public void createSortables() {
        sortable.addAll(Arrays.asList(
                new Student("Student1", 2.2),
                new Student("Student2", 3.2),
                new Student("Student3", 3.2),
                new Student("Student4", 2.2),
                new Student("Student5", 6.2),
                new Student("Student6", 2.2)
        ));

        linearSortable.addAll(Arrays.asList(
                new Student("Student1", (double) 2),
                new Student("Student2", (double) 3),
                new Student("Student3", (double) 4),
                new Student("Student4", (double) 1),
                new Student("Student5", (double) 5),
                new Student("Student6", (double) 6)
        ));

    }

    @Test
    public void shouldSortArrayToCorrectOrder() {
        linearSortable = sorter.sort(linearSortable);
        Student prev = null;
        for (Student v : linearSortable) {
            if (null != prev) {
                assertTrue(prev.getGrade() > v.getGrade());
            }
            prev = v;
        }
    }

    @Test
    public void shouldSortWithOverlappingValues() {
        sortable = sorter.sort(sortable);
        Student prev = null;
        for (Student v : sortable) {
            if (null != prev) {
                assertTrue(prev.getGrade() >= v.getGrade());
            }
            prev = v;
        }
    }

}
