package com.hallila.sorter.impl;

import com.hallila.pojo.Student;
import com.hallila.sorter.Sorter;

import java.util.List;

/**
 * Created by jussi on 08/05/14.
 */
public class HeapSorter implements Sorter {


    @Override
    public List<Student> sort(List<Student> studentList) {
        for (int heapsize = 0; heapsize < studentList.size(); heapsize++) {
            int n = heapsize;
            while (n > 0) {
                int p = (n - 1) / 2;
                double pGrade = studentList.get(p).getGrade();
                double nGrade = studentList.get(n).getGrade();
                if (nGrade < pGrade) {
                    swap(studentList, n, p);
                    n = p;
                } else
                    break;
            }
        }

        for (int heapsize = studentList.size(); heapsize > 0; ) {
            swap(studentList, 0, --heapsize);
            int n = 0;
            while (true) {
                int left = (n * 2) + 1;
                if (left >= heapsize)
                    break;
                int right = left + 1;
                double leftGrade = studentList.get(left).getGrade();
                double rightGrade = studentList.get(right).getGrade();
                if (right >= heapsize) {
                    if (leftGrade < studentList.get(n).getGrade())
                        swap(studentList, left, n);
                    break;
                }
                if (leftGrade < studentList.get(n).getGrade()) {
                    if (leftGrade < rightGrade) {
                        swap(studentList, left, n);
                        n = left;
                    } else {
                        swap(studentList, right, n);
                        n = right;
                    }
                } else {
                    if (rightGrade < studentList.get(n).getGrade()) {
                        swap(studentList, right, n);
                        n = right;
                    } else {
                        break;
                    }
                }
            }
        }
        return studentList;
    }


    private void swap(List<Student> studentList, int i, int j) {
        Student temp = studentList.get(i);
        studentList.set(i, studentList.get(j));
        studentList.set(j, temp);
    }

}