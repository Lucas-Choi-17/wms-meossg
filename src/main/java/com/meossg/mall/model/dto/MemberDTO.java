package com.meossg.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberDTO {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String password;

    @Override
    public String toString() {
        return "[ ID: " + id + " | " +
                "비밀번호: " + password + " | " +
                "이름: " + name + " | " +
                "전화번호: " + phone + " | " +
                "주소: " + address + " ]";
    }
}
