package com.example.wxlogindemo.service;

import com.example.wxlogindemo.entity.UserInfo;
/**
 * @author wxy
 */
public interface UserService {
    /**
     * 根据openId查询是否有该用户
     * @param openId
     * @return
     */
    UserInfo getItemByOpenId(String openId);
}
