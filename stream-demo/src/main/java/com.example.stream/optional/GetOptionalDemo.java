package com.example.stream.optional;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.Optional;

/**
 * 获取Optional
 */
public class GetOptionalDemo {
    public static void main(String[] args) {
        /**
         * get方法将获取Optional中value的值，如果存在值，则返回该值，否则抛出NoSuchElementException。
         */
        Optional<String> optional = Optional.of("Hello,Optional");
        Optional<Object> optEmpty = Optional.ofNullable(null);
        System.out.println(optional.get());
       // System.out.println(optEmpty.get());


        /**
         * 如果Optional实例有值则将其返回，否则返回orElse方法传入的参数。
         */
        System.out.println(optional.orElse("有值"));
        System.out.println(optEmpty.orElse("没有值"));


        /**
         * orElseGet与orElse方法类似，区别在于得到的默认值。
         * orElse方法将传入的字符串作为默认值，orElseGet方法可以接受Supplier接口的实现用来生成默认值。
         */

        System.out.println(optEmpty.orElseGet(() -> "Default value"));
        System.out.println(optional.orElseGet(() -> "default value"));


        /**
         * 在orElseGet方法中，我们传入一个Supplier接口。
         * 然而，在orElseThrow中我们可以传入一个lambda表达式或方法，如果值不存在来抛出异常。
         */

        //System.out.println(optEmpty.orElseThrow(ValueAbsentException::new));

    }
}
