package com.hallila.pojo;

/**
 * Created by jussi on 08/05/14.
 */
public class Student {
    private String name;
    private Double grade;

    public Student() {
    }

    public Student(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public Double getGrade() {
        return grade;
    }

}
