package com.meossg.member.controller;

import com.meossg.member.model.dto.UserDTO;

import java.util.List;

public class PrintResult {
    public void printMemberList(List<UserDTO> memberList){

        for (UserDTO user : memberList){
            System.out.println(user);
        }
    }

    public void printMember(UserDTO user) {
        System.out.println(user);
    }


    public void printErrorMessage(String errorCode){

        String errorMessage = "";

        switch (errorCode){
            case "update" : errorMessage = "개인 정보 수정을 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode){
        String successMessage = "";

        switch (successCode) {
            case "update" : successMessage = "개인 정보 수정을 성공하였습니다."; break;
        }
        System.out.println(successMessage);
    }
}
