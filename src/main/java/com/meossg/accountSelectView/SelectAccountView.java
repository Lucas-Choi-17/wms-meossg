package com.meossg.accountSelectView;

import java.util.Scanner;

public class SelectAccountView {

    public void selectAccount() {

        Scanner sc = new Scanner(System.in);
        String menu = """
                =======================
                1. 고객 접속
                2. 쇼핑몰 관리자 접속
                3. 창고 관리자 접속
                9. 종료
                선택 :\s""";

        while (true) {
            System.out.print(menu);
            String input = sc.next();
            sc.nextLine();
            switch (input) {
                case "1":
                    // 고객 접속
                    break;
                case "2":
                    // 쇼핑몰 관리자 접속
                    break;
                case "3":
                    // 창고 관리자 접속
                    break;
                case "9":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }
}
