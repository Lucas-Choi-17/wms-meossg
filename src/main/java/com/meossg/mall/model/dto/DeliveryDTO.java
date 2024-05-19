package com.meossg.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeliveryDTO {
    private String id;
    private String orderId;
    private String status;
    private String trackingNumber;

    @Override
    public String toString() {
        return "[ 배송 번호 : " + id + " |" +
                " 주문 번호 : " + orderId + " |" +
                " 배송상태 : " + status + " |" +
                " 운송자 번호 : " + trackingNumber +
                " ]";
    }
}

