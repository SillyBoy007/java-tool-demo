package com.example.stream.lambada;

import java.util.function.Function;

public class TypeAssertDemo {
    public static void main(String[] args) {
        Function<String,Integer> strInteger = Integer::valueOf;
        //Function str = Integer::valueOf;
        Integer e = strInteger.apply("7");
        System.out.println(e);

        /**
         * javac会挑出最具体的类型,输入字符串输出"String",输入其他类型，返回"Object"
         */
        overloaded("i");
        /**
         * Lambda表达式作为参数时，其类型由它的目标类型推导得出，推导过程遵循如下规则：
         *
         * 如果只有一个可能的目标类型，由相应函数接口里的参数类型推导得出；
         * 如果有多个可能的目标类型，由最具体的类型推导得出；
         * 如果有多个可能的目标类型且最具体的类型不明确， 则需人为指定类型。
         *
         */
        //overloaded((x)->y);
        //overloadedMethod((x)->(String)y);


    }

    private static void overloaded(Object o){
        System.out.println("Object");
    }
    private static void overloaded(String s){
        System.out.println("String");
    }

}
