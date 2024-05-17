package com.meossg.warehouse.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InWarehouseDTO {

    private int id;
    private int productId;
    private Date InDate;

}
