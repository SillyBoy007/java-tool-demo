package com.example.jetcache.service.impl;

import com.example.jetcache.service.UserService;
import com.example.jetcache.entity.UserPO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserPO getUserById(long userId) {

        return new UserPO(1L,"Wang");
    }
}
