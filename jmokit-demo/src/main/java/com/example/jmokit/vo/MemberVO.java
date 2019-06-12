package com.example.jmokit.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
    private Long userNo;
    private String userName;
    private Date birthday;
    private Integer sex;
    private Boolean isSeller;
    private StoreVO storeVO;

    public MemberVO() {
    }

    public MemberVO(Long userNo, String userName, Date birthday, Integer sex, Boolean isSeller, StoreVO storeVO) {
        this.userNo = userNo;
        this.userName = userName;
        this.birthday = birthday;
        this.sex = sex;
        this.isSeller = isSeller;
        this.storeVO = storeVO;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", isSeller=" + isSeller +
                '}';
    }

}
