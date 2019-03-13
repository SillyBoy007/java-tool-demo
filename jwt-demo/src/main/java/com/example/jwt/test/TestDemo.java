package com.example.jwt.test;


import com.example.jwt.domain.UserDTO;
import com.example.jwt.utils.JwtUtils;

public class TestDemo {
    public static void main(String[] args) {
        try {
            UserDTO userEo = new UserDTO();
            userEo.setOpen_id("asdewqe1111111111ewew");
            userEo.setId(1L);
            String token = JwtUtils.createToken(userEo);
            System.out.println("生成JWT的token===="+token);

            UserDTO user = JwtUtils.getVtoken(token);
            System.out.println("解密Jwt======"+user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
