package com.example.jmokit.nolmal;

import com.example.jmokit.bean.AnOrdinaryClass;
import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

public class ClassMockingByExpectationsTest {
    @Test
    public void testClassMockigByExpectation(){
        AnOrdinaryClass instanceToRecord = new AnOrdinaryClass();
        new Expectations(AnOrdinaryClass.class){
            {
                // mock静态方法
                AnOrdinaryClass.staticMethod();
                result = 10;
                // mock普通方法
                instanceToRecord.ordinaryMethod();
                result = 20;
                // mock final方法
                instanceToRecord.finalMethod();
                result = 30;
                // native, private方法无法用Expectations来Mock
              /*  instanceToRecord.navtiveMethod();
                result = 4;
                instanceToRecord.callPrivateMethod();
                result = 5;*/

            }
        };
        AnOrdinaryClass instance = new AnOrdinaryClass();
        Assert.assertTrue(AnOrdinaryClass.staticMethod() == 10);
        Assert.assertTrue(instance.ordinaryMethod() == 20);
        Assert.assertTrue(instance.finalMethod() == 30);
        // 用Expectations无法mock native方法
       // Assert.assertTrue(instance.navtiveMethod() == 4);
        // 用Expectations无法mock private方法
      //  Assert.assertTrue(instance.callPrivateMethod() == 5);
    }

}
