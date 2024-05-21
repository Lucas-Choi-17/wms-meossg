package com.meossg.mall.view;

import com.meossg.mall.controller.mallController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MallAnalysisView {
    public void analysisMenu() {
        Scanner sc = new Scanner(System.in);
        String menu = """
                =========================
                통계 및 분석
                =========================
                1. 수익 확인
                2. 판매량 확인
                0. 뒤로가기
                =========================
                입력:\s""";

        while (true) {
            System.out.print(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    checkProfit();
                    // 수익 확인
                    break;
                case 2:
                    // 판매량 확인
                    checkSalesRateMenu();
                case 0:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("다시 입력하세요 : ");
            }
        }
    }

    private void checkSalesRateMenu() {
        mallController mallController = new mallController();
        Scanner sc = new Scanner(System.in);
        String menu = """
                =========================
                판매량 확인
                -------------------------
                1. 전체 판매량 확인
                2. 제품별 판매량 확인
                0. 뒤로가기
                -------------------------
                =========================
                """;
        while (true) {
            System.out.println(menu);
            System.out.print("메뉴를 선택해 주세요 : ");
            String choice = sc.nextLine().charAt(0) + "";
            switch (choice) {
                case "1":
                    // 전체 판매량 확인
                    mallController.selectTotalSalesRate();
                    break;
                case "2":
                    // 제품별 판매량 확인
                    mallController.selectSalesRateByProduct(inputName());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }

        }
    }

    private Map<String, String> inputName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("판매량을 확인할 제품명을 입력하세요 : ");
        String productName = sc.nextLine();
        Map<String, String> map = new HashMap<>();
        map.put("productName", productName);

        return map;
    }


    private void checkProfit() {
        mallController mallController = new mallController();
        Scanner sc = new Scanner(System.in);
        String menu = """
                =========================
                수익 확인
                =========================
                1. 전체 기간 수익 조회
                2. 단위 기간 수익 조회
                3. 제품별 수익 조회
                0. 뒤로가기
                =========================
                입력:\s""";

        while (true) {
            System.out.print(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    // 전체 기간 수익 조회
                    mallController.getTotalProfit();
                    break;
                case 2:
                    // 단위 기간 수익 조회
                    mallController.getPeriodProfit(getPeriod());
                    break;
                case 3:
                    mallController.profitOfEachProduct();
                    break;
                case 0:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("다시 입력하세요.");
            }
        }
    }

    private Map<String, Integer> getPeriod() {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        System.out.println("------< 기간별 수익 확인 >------");
        while (true) {
            System.out.print("확인하려는 연도와 월을 입력하세요(연도 월) - (0: 종료): ");
            String period = sc.nextLine();

            if (period.equals("0")) {
                return map;
            }

            int year = Integer.parseInt(period.substring(0, 4));
            int month = 0;
            if (period.length() == 7) {
                month = Integer.parseInt(period.substring(5, 7));
            } else if (period.length() == 6) {
                month = Integer.parseInt(period.substring(5, 6));
            }

            System.out.println(year + "년 " + month + "월");
            if (month >= 1 && month <= 12) {
                map.put("year", year);
                map.put("month", month);
                return map;
            } else {
                System.out.println("다시 입력하세요.");
            }
        }
    }
}
