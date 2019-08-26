package com.example.stream.method;

import com.example.stream.model.Person;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 参考链接:https://blog.csdn.net/IO_Field/article/details/55045639
 * 方法引用之引用静态方法
 */
public class MethodQuoteStatic {
    public static void main(String[] args) {
        Person[] persons = new Person[]{};

        //匿名内部类
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        //使用lambda
        Arrays.sort(persons,(o1,o2) -> o1.getBirthday().compareTo(o2.getBirthday()));

        //使用lambda和类静态方法
        Arrays.sort(persons,(o1,o2) -> Person.compareAge(o1,o2));

        //使用方法引用
        //引用的是静态类型
        Arrays.sort(persons,Person::compareAge);


    }


}
