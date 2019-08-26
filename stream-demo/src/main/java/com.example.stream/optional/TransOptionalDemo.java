package com.example.stream.optional;


import java.util.Optional;

/**
 * 转换Optional
 */
public class TransOptionalDemo {
    public static void main(String[] args) {
        /**
         * filter方法检查给定的Option值是否满足某些条件。
         * 如果满足则返回同一个Option实例，否则返回空Optional。
         */
        Optional<Integer> integer = Optional.of(20);
        Optional<Integer> oldAge = integer.filter(a -> a > 18);
        Optional<Integer> lessAge = integer.filter(a -> a < 18);

        System.out.println(oldAge);
        System.out.println(lessAge);

        /**
         * map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口的lambda表达式传入操作。
         * 如果有值，则对其执行调用mapping函数得到返回值。
         * 如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional。
         */

        Optional<Object> empty = Optional.empty();
        Optional<Integer> ageMap = Optional.of(20);
        Optional<String> age = ageMap.map(a -> "Age is:" + a);
        Optional<String> emptyAge = empty.map(a -> "Age is" + a);
        Optional<Object> emptyNull = ageMap.map(a -> null);
        System.out.println(age);
        System.out.println(emptyAge);
        System.out.println(emptyNull);


        /**
         * flatMap
         * 如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。
         * flatMap与map（function）方法类似，区别在于flatMap中的mapper返回值必须是Optional。
         * 调用结束时，flatMap不会对结果用Optional封装。
         */
        Optional<String> flatMap = Optional.of("hello flatMap");
        String opt = flatMap.flatMap(it -> Optional.of(it.toUpperCase())).orElseGet(()->"str");
        System.out.println(opt);


    }
}
