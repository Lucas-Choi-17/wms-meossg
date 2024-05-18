package com.meossg.mall.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockDTO {
    private int id;
    private String name;
    private int count;
}
