package com.example.jetcache.controller;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.jetcache.entity.UserPO;
import com.example.jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @CreateCache(expire = 10000, cacheType = CacheType.REMOTE, localLimit = 50)
    private Cache<Long, UserPO> userCache;

    @GetMapping("/user/get/{userId}")
    public UserPO getUserPOById(@PathVariable("userId") long userId){

        UserPO user = userCache.get(1234567L);
        if (user == null){
            user =  userService.getUserById(userId);
           userCache.put(2233L, userService.getUserById(userId));
          //userCache.computeIfAbsent(null, (key) -> userService.getUserById(12345L));

        }
       // userCache.remove(1234567L);
       // userService.getUserById(12345L);

        return user;
    }
}
