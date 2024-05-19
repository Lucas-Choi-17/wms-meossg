package com.meossg.mall.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderId;
    private String userName;
    private String productName;
    private int count;
    private int totalPrice;
}
