package com.meossg.mall.view;

import com.meossg.mall.model.dto.AdminDTO;

import java.util.Scanner;

public class MallMenuView {


    public void mallMenu(AdminDTO admin) {
        String menu = """
                ============================
                1. 상품관리
                2. 배송관리
                3. 회원관리
                4. 통계 및 분석
                0. 로그아웃
                ============================
                선택 :\n""";
        while (true) {
            System.out.print(menu);
            String input = new Scanner(System.in).next();
            switch (input) {
                case "1":
                    // 상품 관리
                    break;
                case "2":
                    // 배송 관리
                    break;
                case "3":
                    // 회원 관리
                    break;
                case "4":
                    // 통계 및 분석
                    break;
                case "0":
                    // 로그아웃
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }
}
