package com.meossg.member.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private int id;
    private String name;
    private int price;
    private String size;
    private String color;
    private String availability;

    @Override
    public String toString() {
        return "[ 상품번호 : " + id +
                " | 상품명 : " + name +
                " | 가격 : " + price +
                " | 상품크기 : " + size +
                " | 색상 : " + color +
                " ]";
    }
}
