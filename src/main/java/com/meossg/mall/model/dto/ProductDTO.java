package com.meossg.mall.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    private String id;
    private String name;
    private int price;
    private String size;
    private String color;
    private String availability;

}
