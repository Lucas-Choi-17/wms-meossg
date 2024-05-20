package com.meossg.warehouse.view;

import com.meossg.warehouse.controller.OutWarehouseController;
import com.meossg.warehouse.controller.WarehouseController;

import java.util.Scanner;

public class WarehouseMenuView {

    Scanner sc = new Scanner(System.in);
    OutWarehouseView ov = new OutWarehouseView();
    WarehouseController wc = new WarehouseController();
    OutWarehouseController oc = new OutWarehouseController();

    public void warehouseMenu() {

        String menu = """
                =======================
                1. 발주 목록  조회
                2. 출고
                3. 출고 내역 조회
                4. 입고내역 조회 ( 보여준 후에 입고? 아니면 5번으로 입고를 뺄까요??)
                5. 창고 재고 조회
                """+
//                5. 입고
                """
                9. 로그아웃
                선택 :\s""";

        while (true) {
            System.out.print(menu);
            String input = sc.next();
            switch (input) {
                case "1":
                    // 발주 목록 조회
                    ov.printPlacingOrder();
                    break;
                case "2":
                    // 출고
                    ov.printOrderList();
                    break;
                case "3":
                    // 출고 내역 조회
                    break;
                case "4":
                    // 입고 내역 조회

                case "5":
                    //창고 재고 조회
                    WarehouseController.getInWarehouse();
                    break;
//
                case "9":
                    System.out.println("로그아웃 합니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }
}
