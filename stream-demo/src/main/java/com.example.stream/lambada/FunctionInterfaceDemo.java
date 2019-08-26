package com.example.stream.lambada;


import com.example.stream.api.IFunctionInterface;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        IFunctionInterface mathInterface = (x, y)-> x-y;
        mathInterface.doMathOperator(10,3);

        /**
         * 函数式接口(Functional Interface)是Java 8对一类特殊类型的接口的称呼。
         * 这类接口只定义了唯一的抽象方法的接口（除了隐含的Object对象的公共方法），用作Lambda表达式的类型。
         */
        IFunctionInterface iMathInterface = Math :: doIntPlus;
        int i = iMathInterface.doMathOperator(3, 4);
        System.out.println("result="+i);
    }
}
