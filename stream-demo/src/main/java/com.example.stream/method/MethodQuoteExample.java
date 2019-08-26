package com.example.stream.method;

import java.util.Arrays;

/**
 * 参考链接:https://blog.csdn.net/IO_Field/article/details/55045639
 * 引用实例方法
 */
public class MethodQuoteExample {
    public static void main(String[] args) {
        String[] strings = {"hello","world"};

        //使用lambda表达式和类型对象的实例方法
        Arrays.sort(strings,(s1,s2) -> s1.compareToIgnoreCase(s2));

        //使用方法引用
        //引用是类型对象的实例方法
        Arrays.sort(strings,String::compareToIgnoreCase);


    }
}
