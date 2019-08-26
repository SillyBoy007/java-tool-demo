package com.example.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int stuNo;
    private String sex;
    private String name;
    private int height;

    public Student(int stuNo, String name) {
        this.stuNo = stuNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public Student(int stuNo, String name, int height) {
        this.stuNo = stuNo;
        this.name = name;
        this.height = height;
    }

    public static List<Student> getStudentList(){
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();

        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);
        return list;
    }
}
