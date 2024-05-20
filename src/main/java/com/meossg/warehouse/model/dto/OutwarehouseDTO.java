package com.meossg.warehouse.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OutwarehouseDTO {
    private int id;
    private int orderNumber;
    private String name;
    private Date outDate;
    private String address;
}
