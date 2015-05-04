package com.hallila.sorter;

import com.hallila.pojo.Student;

import java.util.List;

/**
 * Created by jussi on 08/05/14.
 */
public interface Sorter {
    List<Student> sort(List<Student> studentList);
}
