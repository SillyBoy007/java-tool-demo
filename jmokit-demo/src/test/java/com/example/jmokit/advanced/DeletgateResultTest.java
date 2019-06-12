package com.example.jmokit.advanced;

import com.example.jmokit.service.ISayHello;
import com.example.jmokit.service.impl.SayHelloImpl;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Invocation;
import org.junit.Test;
import org.springframework.util.Assert;

public class DeletgateResultTest {
    @SuppressWarnings("rawtypes")
    @Test
    public void testDelegate() {
        new Expectations(SayHelloImpl.class) {
            {
                ISayHello instance = new SayHelloImpl();
                instance.sayHello(anyString, anyInt);
                result = new Delegate() {
                    // 当调用sayHello(anyString, anyInt)时，返回的结果就会匹配delegate方法，
                    // 方法名可以自定义，当入参和返回要与sayHello(anyString, anyInt)匹配上
                    @SuppressWarnings("unused")
                    String delegate(Invocation inv, String who, int gender) {
                        // 如果是向动物鹦鹉Polly问好，就说hello,Polly
                        if ("Polly".equals(who)) {
                            return "hello,Polly";
                        }
                        // 其它的入参，还是走原有的方法调用
                        return inv.proceed(who, gender);
                    }
                };

            }
        };

        ISayHello instance = new SayHelloImpl();
        Assert.isTrue(instance.sayHello("david", ISayHello.MALE).equals("hello Mr david"));
        Assert.isTrue(instance.sayHello("lucy", ISayHello.FEMALE).equals("hello Mrs lucy"));
        Assert.isTrue(instance.sayHello("Polly", ISayHello.FEMALE).equals("hello,Polly"));
    }
}
