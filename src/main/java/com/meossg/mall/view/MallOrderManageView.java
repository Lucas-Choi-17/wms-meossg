package com.meossg.mall.view;

import com.meossg.mall.controller.mallController;

import java.util.Scanner;

public class MallOrderManageView {

    public void orderManagingMenu() {
        mallController mallController = new mallController();
        String menu = """
                ============================
                주문 관리
                ============================
                1. 주문 내역 조회
                2. 주문 승인
                3. 배송 확인
                0. 뒤로 가기
                ============================
                선택 :\s""";

        while (true) {
            System.out.print(menu);
            String input = new Scanner(System.in).next();
            switch (input) {
                case "1":
                    // 주문 내역 조회
                    mallController.getAllOrderList();
                    break;
                case "2":
                    // 주문 승인
                    mallController.approveOrder();
                    break;
                case "3":
                    // 배송 확인
                    mallController.showPostStatus();
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
