package com.meossg.mall.view;

import java.util.Scanner;

public class MallProductManageView {

    public void productManagingMenu() {
        String menu = """
                ============================
                상품 관리
                ============================
                1. 상품 등록
                2. 상품 정보 변경
                3. 발주
                4. 재고 조회
                0. 뒤로 가기
                ============================
                선택 :\n""";

        while (true) {
            System.out.print(menu);
            String input = new Scanner(System.in).next();
            switch (input) {
                case "1":
                    // 상품 등록
                    break;
                case "2":
                    // 상품 정보 변경
                    break;
                case "3":
                    // 발주
                    break;
                case "4":
                    // 재고 조회
                    break;
                case "0":
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }
}
