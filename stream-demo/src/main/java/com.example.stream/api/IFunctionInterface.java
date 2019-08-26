package com.example.stream.api;

/**
 * 函数接口的特性
 *
 * 1.只具有一个方法的接口
 * 2.其可以被隐式转换为lambda表达式
 * 3.现有静态方法可以支持lambda表达式
 * 4.每个用作函数接口的接口都应添加 @FunctionalInterface注释
 */
@FunctionalInterface
public interface IFunctionInterface {
    int doMathOperator(int start,int plusValue);
}
