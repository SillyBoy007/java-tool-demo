package com.example.stream.optional;

import java.util.Optional;

/**
 * 创建Optional
 */
public class CreateOptionalDemo {
    public static void main(String[] args) {
        /**
         * empty方法通过工厂创建一个空的Optional.
         */

        Optional optional = Optional.empty();



        /**
         * of工厂方法创建optional类
         * 创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException。
         */
        Optional<String> sakura = Optional.of("Sakura");
        //Optional<String> optionalS = Optional.of(null);



        /**
         * ofNullable与of方法相似，唯一的区别是可以接受参数为null的情况
         */

        Optional ofNull = Optional.ofNullable(null);



        /**
         * isPresent用来判断Optional是否有值。如果值存在返回true，否则返回false。
         */
        Optional emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());

        Optional<String> opt = Optional.of("a");
        System.out.println(opt.isPresent());







    }
}
