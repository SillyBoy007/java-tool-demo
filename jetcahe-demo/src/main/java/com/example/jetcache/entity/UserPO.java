package com.example.jetcache.entity;

import java.io.Serializable;

/**
 * 一定要加上Serializable否则无法序列化
 */
public class UserPO implements Serializable {
    private Long userId;
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserPO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
