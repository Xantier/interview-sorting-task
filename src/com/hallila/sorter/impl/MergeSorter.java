package com.hallila.sorter.impl;

import com.hallila.pojo.Student;
import com.hallila.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jussi on 08/05/14.
 */
public class MergeSorter implements Sorter {

    @Override
    public List<Student> sort(List<Student> studentList) {
            if (studentList.size() <= 1) {
                return studentList;
            }
            List<Student> firstHalf = new ArrayList<Student>();
            List<Student> secondHalf = new ArrayList<Student>();
            for (int i = 0; i < studentList.size() / 2; i++) {
                firstHalf.add(studentList.get(i));
            }
            for (int i = studentList.size() / 2; i < studentList.size(); i++) {
                secondHalf.add(studentList.get(i));
            }
            return merge(sort(firstHalf), sort(secondHalf));
        }

        private List<Student> merge(List<Student> l1, List<Student> l2) {
            if (l1.size() == 0) {
                return l2;
            }
            if (l2.size() == 0) {
                return l1;
            }
            List<Student> result = new ArrayList<Student>();
            Student nextElement;
            if (l1.get(0).getGrade() < l2.get(0).getGrade()) {
                nextElement = l2.get(0);
                l2.remove(0);
            } else {
                nextElement = l1.get(0);
                l1.remove(0);
            }
            result.add(nextElement);
            result.addAll(merge(l1,l2));
            return result;
        }
}
