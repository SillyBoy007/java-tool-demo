package com.example.jmokit.service.impl;

import com.example.jmokit.service.MemberService;
import com.example.jmokit.vo.MemberVO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public MemberVO getMember() {
        MemberVO memberVO = new MemberVO();
        memberVO.setBirthday(new Date());
        memberVO.setIsSeller(true);
        memberVO.setSex(1);
        memberVO.setUserName("wang");
        memberVO.setUserNo(1123456677777L);
        return memberVO;
    }

    public static MemberVO getMemberVOInstance(){
        return new MemberVO();
    }
}
