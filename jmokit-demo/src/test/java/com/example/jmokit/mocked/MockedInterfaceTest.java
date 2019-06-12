package com.example.jmokit.mocked;

import com.example.jmokit.service.MemberService;
import com.example.jmokit.vo.MemberVO;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;


public class MockedInterfaceTest {

    // 加上了JMockit的API @Mocked, JMockit会帮我们实例化这个对象，尽管这个对象的类型是一个接口，不用担心它为null
    @Mocked
    MemberService memberService;

    // 当@Mocked作用于interface
    @Test
    public void testMockedInterface(){
        MemberVO member = memberService.getMember();
        Assert.assertTrue(member.getIsSeller() == false);
        Assert.assertTrue(member.getSex() == 0);
        Assert.assertTrue(member.getUserName() == null);
        Assert.assertTrue(member.getBirthday() != null);
        Assert.assertTrue(member.getUserNo() == 0L);
        Assert.assertTrue(member.getStoreVO() != null);

    }
}
