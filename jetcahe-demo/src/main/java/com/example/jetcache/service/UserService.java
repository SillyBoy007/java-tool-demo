package com.example.jetcache.service;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.example.jetcache.entity.UserPO;

public interface UserService {
   //@Cached(expire = 3600, cacheType = CacheType.REMOTE)
    UserPO getUserById(long userId);
}
