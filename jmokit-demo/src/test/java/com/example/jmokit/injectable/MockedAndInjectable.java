package com.example.jmokit.injectable;

import com.example.jmokit.vo.MemberVO;
import com.example.jmokit.vo.StoreVO;
import mockit.Injectable;
import mockit.Mocked;
import org.junit.Test;

import java.util.Date;

//@Mocked与@Injectable的不同
public class MockedAndInjectable {
    // 加上了JMockit的API @Mocked, JMockit会帮我们实例化这个对象，尽管这个对象的类型是一个接口，不用担心它为null

    @Test
    public void testMocked(@Mocked MemberVO member) {
        MemberVO newMember = new MemberVO(1L,"wang",new Date(),1,true,new StoreVO());
        System.out.println(newMember);
    }

    @Test
    public void testInjectable(@Injectable MemberVO member) {
        MemberVO newMember = new MemberVO(1L,"wang",new Date(),1,true,new StoreVO());
        System.out.println(newMember);

    }
}