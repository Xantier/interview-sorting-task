package com.hallila.middleware;

import com.hallila.pojo.Student;
import com.hallila.sorter.SorterEnum;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SorterDispatcherTest {
    private static List<String> studentNames = Arrays.asList("Student1", "Student2", "Student3");
    private static List<Double> studentGrades = Arrays.asList(8.5, 6.5, 5.0);

    @Test
    public void shouldTakeInFileAndSortItToStudentList() {
        File file = new File("test/resources/testInputWithBlanks.txt");
        SorterEnum enumerable = SorterEnum.BUBBLE;
        SorterDispatcher dispatcher = new SorterDispatcher(file, enumerable);
        List<Student> result = null;
        try {
            //noinspection unchecked
            result = (List<Student>) (dispatcher.doInBackground()).get("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result==null){
            fail();
        }
        for(int i = 0; i<result.size();i++){
            assertEquals(result.get(i).getGrade(), studentGrades.get(i));
            assertEquals(result.get(i).getName(), studentNames.get(i));
        }
    }
}