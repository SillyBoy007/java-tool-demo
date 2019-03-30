package com.example.plusdemo.service.impl;

import com.example.plusdemo.model.Member;
import com.example.plusdemo.mapper.MemberMapper;
import com.example.plusdemo.service.MemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangxiayun
 * @since 2019-03-25
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
