package com.hallila.fileio;

import com.hallila.pojo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jussi on 08/05/14.
 */
public class FileParser {

    private File file;

    public FileParser(File file) {
        this.file = file;
    }

    public List<Student> parseFile(){
        List<Student> studentList = new ArrayList<Student>();
        try{
            InputStream is=new FileInputStream(this.file);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null){
                Object values[];
                values=line.split(",");
                if(values.length>1){
                    studentList.add(new Student(String.valueOf(values[0]), Double.parseDouble(String.valueOf(values[1]))));
                }

            }
            br.close();
        }
        catch(Exception e){
            System.err.println("Error: Target File Cannot Be Read");
            e.printStackTrace();
        }
        return studentList;
    }
}
