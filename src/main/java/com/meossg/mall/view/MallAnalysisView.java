package com.meossg.mall.view;

import com.meossg.mall.controller.MallController;

import java.util.Scanner;

public class MallAnalysisView {
    public void analysisMenu() {
        Scanner sc = new Scanner(System.in);
        String menu = """
                =========================
                통계 및 분석
                =========================
                1. 수익 확인
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
                case 0:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("다시 입력하세요 : ");
            }
        }
    }

    private void checkProfit() {
        MallController mallController = new MallController();
        Scanner sc = new Scanner(System.in);
        String menu = """
                =========================
                수익 확인
                =========================
                1. 전체 기간 수익 조회
                2. 단위 기간 수익 조회
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
//                    mallController.getPeriodProfit();
                    break;
                case 0:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("다시 입력하세요.");
            }
        }
    }
}
