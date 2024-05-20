package com.meossg.warehouse.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListDTO {
    private int orderId;
    private String name;
    private int count;
}
