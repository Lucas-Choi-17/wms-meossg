package com.meossg.warehouse.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberOrderDTO {
    private int id;
    private String memberId;
    private String orderApproveyn;
    private String deliveryn;
}
