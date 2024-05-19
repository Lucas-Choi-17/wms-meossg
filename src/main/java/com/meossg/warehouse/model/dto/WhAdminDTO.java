package com.meossg.warehouse.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WhAdminDTO {
    private String id;
    private String name;
    private String association;
    private String password;
}
