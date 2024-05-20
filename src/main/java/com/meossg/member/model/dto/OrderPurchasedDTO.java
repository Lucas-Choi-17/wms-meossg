package com.meossg.member.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderPurchasedDTO {
    private int orderId;
    private String productName;
    private int count;
    private String orderStatus;

    @Override
    public String toString() {
        return "OrderPurchasedDTO{" +
                "주문번호: " + orderId +
                ", 상품명: " + productName + '\'' +
                ", 수량: " + count +
                ", 주문상태: " + orderStatus + '\'' +
                '}';
    }
}

// 주문번호
// 상품 이름
// 주문 수량
// 주문 상태 - 승인대기중, 배송 대기, 배송 완료