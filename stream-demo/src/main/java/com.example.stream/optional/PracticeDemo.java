package com.example.stream.optional;

import com.example.stream.model.Person;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.junit.Test;

import java.util.Optional;

public class PracticeDemo {
    @Test
    public void test1(){
        Person person = null;
        //person.getBirthday().getName();
        Person person1 = new Person("wa",null,null,"8147522@qq.com");


        Person orElse = Optional.ofNullable(person).orElse(person1);
        Person orElseGet = Optional.ofNullable(person).orElseGet(() -> person1);
        System.out.println(orElse);
        System.out.println(orElseGet);
    }

    /**
     * orElse与orElseGet不同之处
     * 两个 Optional  对象都包含非空值，两个方法都会返回对应的非空值。
     * 不过，orElse() 方法仍然创建了 User 对象。与之相反，orElseGet() 方法不创建 User 对象。
     * 在执行较密集的调用时，比如调用 Web 服务或数据查询，这个差异会对性能产生重大影响。
     */
    @Test
    public void orElseAndOrElseGetDiff(){
        Person person1 = null;
        Person person2 = new Person();

        Person orElse = Optional.ofNullable(person2).orElse(createPerson(1));
        Person orElseGet = Optional.ofNullable(person2).orElseGet(() -> createPerson(2));


    }

    public Person createPerson(int count){
        System.out.println(String.format("use createPerson%s",count));
        return new Person();
    }

    @Test
    public void whenThrowException(){
        Person person = null;
        Person elseThrow = Optional.ofNullable(person).orElseThrow(IllegalArgumentException::new);
        System.out.println(elseThrow);
    }

    @Test
    public void mapFun(){
        Person person = new Person();
        person.setEmail("heh");
        String email = Optional.ofNullable(person).map(Person::getEmail).orElse("8157@qq.com");
        System.out.println(email);
    }
    @Test
    public void flatMap(){
        Person person = new Person("wang",null,null,"dsd@qq.com");
       // Optional.ofNullable(person).flatMap((p -> p.getEmail()).orElse("");
    }

}
