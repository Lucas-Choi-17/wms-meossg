package com.meossg.warehouse.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlacingOrderDTO {
    private int id;
    private String name;
    private int count;
    private Date orderDate;
    private String inwarehouseyn;

}
