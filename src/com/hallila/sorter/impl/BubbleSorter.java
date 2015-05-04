package com.hallila.sorter.impl;

import com.hallila.pojo.Student;
import com.hallila.sorter.Sorter;

import java.util.List;

/**
 * Created by jussi on 08/05/14.
 */
public class BubbleSorter implements Sorter {


    @Override
    public List<Student> sort(List<Student> studentList)
    {
        int j;
        boolean flag = true;
        Student temp;

        while ( flag )
        {
            flag= false;
            for( j=0;  j < studentList.size() -1;  j++ )
            {
                if ( studentList.get(j).getGrade() < studentList.get(j+1).getGrade() )
                {
                    temp = studentList.get(j);
                    studentList.set(j, studentList.get(j+1));
                    studentList.set(j+1, temp);
                    flag = true;
                }
            }
        }
        return studentList;
    }
}
