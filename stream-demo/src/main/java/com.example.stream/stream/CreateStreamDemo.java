package com.example.stream.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStreamDemo {
    /**
     * 流的创建
     */
    @Test
    public void createStream(){
        //1.Individual values
        Stream<String> stream = Stream.of("a", "b");
        //2.Arrays
        String[] strings = new String[]{"a", "b"};
        stream = Stream.of(strings);
        stream = Arrays.stream(strings);

        //3.Collections
        List<String> list = Arrays.asList(strings);
        stream = list.stream();
    }

    /**
     * Stream类型转换
     * 一个 Stream 只可以使用一次，下面的代码为了简洁而重复使用了数次。
     */
    @Test
    public void changeStream(){
        Stream<String> stream = Stream.of("a", "b");
        //1.array
        String[] strings = stream.toArray(String[]::new);

        //2.Collection
        List<String> stringList = stream.collect(Collectors.toList());
        List<String> stringArrayList = stream.collect(Collectors.toCollection(ArrayList::new));

        //3.String

        String string = stream.collect(Collectors.joining("--"));
        System.out.println(string);

    }


}
