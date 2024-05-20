package com.meossg.mall.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private String size;
    private String color;
    private String availability;

    @Override
    public String toString() {
        return
                "[ 상품명: " + name +
                " | 가격: " + price +
                " | 크기: " + size +
                " | 색상: " + color +
                " | 판매여부: " + availability + " ]";
    }

    public String toStringWithID(){
        return "[ 상품번호 : " + id +
                " | 상품명: " + name +
                        " | 가격: " + price +
                        " | 크기: " + size +
                        " | 색상: " + color +
                        " | 판매여부: " + availability + " ]";
    }
}
