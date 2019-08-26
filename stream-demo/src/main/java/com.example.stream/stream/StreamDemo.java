package com.example.stream.stream;

import com.example.stream.model.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream基本操作
 * 参考链接: https://blog.csdn.net/IO_Field/article/details/54971761
 */
public class StreamDemo {
    private List<Student> stuList = Student.getStudentList();

    /**
     * 生成一个整数 list 的平方数
     * map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。
     * 还有一些场景，是一对多映射关系的，这时需要 flatMap
     */
    @Test
    public void mapDemo(){

        List<Integer> arr = Arrays.asList(1,2,3,4);
        List<Integer> integers = arr.stream().map(i -> i * i).collect(Collectors.toList());

    }

    /**
     * flatMap 把 input Stream 中的层级结构扁平化，
     * 就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字。
     */
    @Test
    public void flatMapDemo(){

        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(3, 5, 6)
        );

        Stream<Integer> stream = listStream.flatMap(Collection::stream);

        String collect = stream.distinct().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);

    }


    /**
     * filter过滤偶数
     */
    @Test
    public  void filterDemo() {

        Integer[] ints = new Integer[]{1,2,3,4,5};

        List<Integer> collect = Stream.of(ints).filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * foreach
     * 从stu列表中获取名字为"G"学生列表,循环打印列表
     * 当需要为多核系统优化时，可以 parallelStream().forEach(),只是此时原有元素的次序没法保证，
     * 并行的情况下将改变串行时操作的行为，此时 forEach 本身的实现不需要调整，
     * 而 Java8 以前的 for 循环 code 可能需要加入额外的多线程逻辑。
     * 但一般认为，forEach 和常规 for 循环的差异不涉及到性能，它们仅仅是函数式风格与传统 Java 风格的差别。
     *
     * 另外一点需要注意，forEach 是 terminal 操作，
     * 因此它执行后，Stream 的元素就被“消费”掉了，你无法对一个 Stream 进行两次 terminal 运算。
     */
    @Test
    public void foreach(){
        stuList.parallelStream().filter(student -> Objects.equals(student.getName(),"G"))
                        .forEach(System.out::println);
    }

    /**
     * forEach 是 terminal 操作，因此它执行后，Stream 的元素就被“消费”掉了，你无法对一个 Stream 进行两次 terminal 运算。
     * forEach 不能修改自己包含的本地变量值，也不能用 break/return 之类的关键字提前结束循环。
     * 可使用peek
     * peek 对每个元素执行操作并返回一个新的 Stream
     *
     */
    @Test
    public void peekDemo(){
        List<String> strings = Stream.of("one", "two", "three")
                                     .peek(System.out::println)
                                     .map(String::toUpperCase)
                                     .peek(System.out::println)
                                     .collect(Collectors.toList());



    }

    /**
     *
     * 这个方法的主要作用是把 Stream 元素组合起来。
     * 它提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。
     * 从这个意义上说，字符串拼接、数值的 sum、min、max、average 都是特殊的 reduce.
     *
     */

    @Test
    public void reduce(){
        //字符串拼接

        String contact = Stream.of("1", "2", "3").reduce("",String::concat);
        System.out.println(contact);

        //求最小值
        Double min = Stream.of(-1.5, 1.0, 2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(min);

        //求和
        Integer sum = Stream.of(1, 2, 3).reduce(0, Integer::sum);
        System.out.println(sum);

        //过滤，拼接字符串ace

        String reduce = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(s -> s.compareTo("Z") > 0)
                .reduce("", String::concat);

        System.out.println(reduce);


    }

    /**
     * limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素（它是由一个叫 subStream 的方法改名而来）。
     */
    @Test
    public void limitSkip(){
        List<Student> studentList = this.getStuList(1000);
        //limit,skip顺序调换结果不同
        List<Student> list = studentList.stream().skip(3).limit(10).collect(Collectors.toList());
        System.out.println(list);
        List<Student> list1 = studentList.stream().limit(10).skip(3).collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * 首先对 5 个元素的 Stream 排序，然后进行 limit 操作
     *
     * 即虽然最后的返回元素数量是 2，但整个管道中的 sorted 表达式执行次数没有像前面例子相应减少。
     *
     * 最后有一点需要注意的是，对一个 parallel 的 Steam 管道来说，如果其元素是有序的，那么 limit 操作的成本会比较大，
     * 因为它的返回对象必须是前 n 个也有一样次序的元素。取而代之的策略是取消元素间的次序，或者不要用 parallel Stream。
     */
    @Test
    public void limitSkip2() {
        List<Student> studentList = this.getStuList(5);
        List<Student> list = studentList.stream().sorted(Comparator.comparing(Student::getName))
                                                 .limit(2)
                                                 .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 对 Stream 的排序通过 sorted 进行，
     * 它比数组的排序更强之处在于你可以首先对 Stream 进行各类 map、filter、limit、skip 甚至 distinct 来减少元素数量后，
     * 再排序，这能帮助程序明显缩短执行时间。
     */
    @Test
    public void sortDemo(){
        List<Student> stuList = this.getStuList(5);
        List<Student> students = stuList.stream().limit(2)
                                                 .sorted(Comparator.comparing(Student::getName))
                                                 .collect(Collectors.toList());
        System.out.println(students);

    }

    /**
     * allMatch：Stream 中全部元素符合传入的 predicate，返回 true
     * anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
     * noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     *
     * 它们都不是要遍历全部元素才能返回结果。例如 allMatch 只要一个元素不满足条件，就 skip 剩下的所有元素，返回 false。
     */
    @Test
    public void matchDemo(){
        List<Student> persons = new ArrayList();
        persons.add(new Student(1, "name" + 1, 10));
        persons.add(new Student(2, "name" + 2, 21));
        persons.add(new Student(3, "name" + 3, 34));
        persons.add(new Student(4, "name" + 4, 6));
        persons.add(new Student(5, "name" + 5, 55));

        boolean match = persons.stream().allMatch(s -> s.getHeight() > 30);
        System.out.println(match);


        boolean anyMatch = persons.stream().anyMatch(s -> s.getHeight() < 30);
        System.out.println(anyMatch);

        boolean noneMatch = persons.stream().noneMatch(s -> s.getHeight() < 0);
        System.out.println(noneMatch);
    }


    /**
     * 从stu列表中获取名字为"G"学生列表，并将名字转为小写，使用","分割输出
     * map
     */
    @Test
    public void practiceDemo(){
        List<String> collect = stuList.stream()
                .filter(s->Objects.equals(s.getName(),"G"))
                .map(s -> s.getName().toLowerCase())
                .collect(Collectors.toList());
        System.out.println(collect.stream().collect(Collectors.joining(",")));
    }



    private List<Student> getStuList(int size){
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            Student student = new Student(i, "name" + i);
            studentList.add(student);
        }
        return studentList;
    }
}
