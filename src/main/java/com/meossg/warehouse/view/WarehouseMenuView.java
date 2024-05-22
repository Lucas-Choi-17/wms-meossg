package com.meossg.warehouse.view;

import com.meossg.warehouse.controller.OutWarehouseController;
import com.meossg.warehouse.controller.WarehouseController;
import com.meossg.warehouse.model.dto.WhStockDTO;

import java.util.List;
import java.util.Scanner;

public class WarehouseMenuView {

    Scanner sc = new Scanner(System.in);
    OutWarehouseView ov = new OutWarehouseView();
    WarehouseController wc = new WarehouseController();

    public void warehouseMenu() {

        String menu = """
                =======================
                1. 발주 목록  조회
                2. 출고
                3. 출고 내역 조회
                4. 입고
                5. 입고 내역 조회
                6. 재고 조회
                """+
//                5. 입고
                """
                9. 로그아웃
                선택 :\s""";

        while (true) {
            System.out.print(menu);
            String input = sc.next();
            sc.nextLine();

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
                    ov.printOutwarehouseList();
                    break;
                case "4":
                    // 입고
                    InWarehouseSubMenu();
                    break;
                case "5":
                    //입고 내역 조회
                    WarehouseController.getInWarehouse();
                    break;
                case "6":
                    // 재고 조회
                    selectStock();
                    break;
                case "9":
                    System.out.println("로그아웃 합니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }

    private void InWarehouseSubMenu() {
        String menu = """
                ===== 입고 메뉴 =====
                1. 발주 목록 조회
                2. 입고
                9. 종료
                선택 :\s""";

        while (true) {
            System.out.print(menu);
            String input = sc.next();
            sc.nextLine();

            switch (input) {
                case "1":
                    // 발주 목록 조회
                    ov.printPlacingOrder();
                    break;
                case "2":
                    // 입고
                    wc.inwarehouse(inputPlacingOrderId());
                    break;
                case "9":
                    System.out.println("종료 합니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }

    private int inputPlacingOrderId() {
        System.out.print("입고하실 발주번호를 입력해 주세요 : ");
        return sc.nextInt();
    }

    private void selectStock() {

        String menu = """
                =======================
                1. 재고 전체 조회
                2. 상품명 조회
                9. 종료
                선택 :\s""";
        while (true) {
            System.out.print(menu);
            String input = sc.next();
            sc.nextLine();

            switch (input) {
                case "1":
                    // 재고 전체 조회
                    selectAllStock();
                    break;
                case "2":
                    // 상품명 조회
                    selectStockByName(inputProductName());
                    break;
                case "9":
                    System.out.println("재고 조회를 종료합니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }

    }

    private void selectAllStock() {
        List<WhStockDTO> stockList = wc.selectAllStock();

        if (stockList != null) {
            System.out.println("\t전체 재고 조회");
            for (WhStockDTO stock : stockList) {
                System.out.println("====================");
                System.out.println("상품명 : " + stock.getName());
                System.out.println("수량 : " + stock.getCount());
            }
        } else {
            System.out.println("해당하는 상품이 없습니다 !!");
        }

    }

    private void selectStockByName(String name) {
        WhStockDTO stock = wc.selectStockByName(name);

        if (stock != null) {
            System.out.println("===== 조회한 상품 =====");
            System.out.println("상품명 : " + stock.getName());
            System.out.println("수량 : " + stock.getCount());
        } else {
            System.out.println("해당하는 상품이 없습니다 !!");
        }
    }

    private String inputProductName() {
        System.out.print("조회하실 상품명을 입력해주세요 : ");
        return sc.nextLine();
    }
}
