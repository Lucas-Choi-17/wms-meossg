package com.meossg.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String password;


    public UserDTO(String id, String password, String name) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | " +
                "비밀번호: " + password + " | " +
                "이름: " + name + " | " +
                "전화번호: " + phone + " | " +
                "주소: " + address + " ]";
    }
}
