package com.meossg.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalesRateDTO {

    private int productId;
    private String productName;
    private int salesCount;

    @Override
    public String toString() {
        return  "[ 상품번호: " + productId +
                " | 상품명: " + productName +
                " | 판매량: " + salesCount + " ]";
    }
}
