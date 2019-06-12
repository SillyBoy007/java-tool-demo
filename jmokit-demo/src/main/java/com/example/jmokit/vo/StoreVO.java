package com.example.jmokit.vo;

import lombok.Data;

@Data
public class StoreVO {
    private Long storeNo;
    private String storeName;

    @Override
    public String toString() {
        return "StoreVO{" +
                "storeNo=" + storeNo +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
