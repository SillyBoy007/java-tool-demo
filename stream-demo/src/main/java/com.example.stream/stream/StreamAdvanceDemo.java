package com.example.stream.stream;

import com.example.stream.model.Student;
import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream进阶
 */
public class StreamAdvanceDemo {
    /**
     * 通过实现 Supplier 接口，你可以自己来控制流的生成。
     * 这种情形通常用于随机数、常量的 Stream，或者需要前后元素间维持着某种状态信息的 Stream。
     * 把 Supplier 实例传递给 Stream.generate() 生成的 Stream，默认是串行（相对 parallel 而言）但无序的（相对 ordered 而言）。
     * 由于它是无限的，在管道中，必须利用 limit 之类的操作限制 Stream 大小。
     */
    /**
     * 生成10个随机数
     */
    @Test
    public void generateDemo(){
        //方式一
        Random seed = new Random();
        Supplier<Integer> supp = seed::nextInt;
        Stream.generate(supp).limit(10).forEach(System.out::println);

        //方式二

        IntStream.generate(() -> (int) (System.nanoTime() % 100))
                 .limit(10)
                 .forEach(System.out::println);


    }

    /**
     * iterate 跟 reduce 操作很像，接受一个种子值，和一个 UnaryOperator（例如 f）。
     * 然后种子值成为 Stream 的第一个元素，f(seed) 为第二个，f(f(seed)) 第三个，以此类推。
     */
    @Test
    public void iterate(){
        Stream.iterate(0,n -> n + 3).limit(10).forEach(x -> System.out.println(x + ""));
    }


}
