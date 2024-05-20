package com.meossg.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MallPlacingOrderDTO {
    private int id;
    private int productId;
    private int count;
    private Date orderDate;
    private String inWarehouseYN;

    @Override
    public String toString() {
        return "{ 발주번호: " + id +
                " | 상품번호: " + productId +
                " | 발주수량: " + count +
                " | 발주일: " + orderDate +
                " | 상품판매여부: " + inWarehouseYN + " }";
    }
}
