package com.hallila.fileio;

import com.hallila.pojo.Student;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FileParserTest {

    private FileParser fileParser;

    @Before
    public void init(){

    }


    @Test
    public void shouldParseFileWithoutBlankLines(){
        //Throws no error
        File file = new File("test/resources/testInputNoBlanks.txt");
        fileParser = new FileParser(file);
        fileParser.parseFile();
    }

    @Test
    public void shouldParseFileWithBlankLines(){
        //Throws no error
        File file = new File("test/resources/testInputWithBlanks.txt");
        fileParser = new FileParser(file);
        fileParser.parseFile();
    }

    @Test
    public void shouldReturnStudentsInOriginalOrder(){
        File file = new File("test/resources/testInputWithBlanks.txt");
        fileParser = new FileParser(file);
        List<Student> students = fileParser.parseFile();
        Student student1 = students.get(0);
        Student student2 = students.get(1);
        Student student3 = students.get(2);
        assertTrue(student1.getGrade() == 8.5);
        assertTrue(student2.getGrade() == 5.0);
        assertTrue(student3.getGrade() == 6.5);
    }

}