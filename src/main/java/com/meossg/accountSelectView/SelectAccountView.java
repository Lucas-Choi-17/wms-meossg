package com.meossg.accountSelectView;

import com.meossg.mall.view.MallLoginView;
import com.meossg.member.view.MemberMenuView;
import com.meossg.warehouse.view.WarehouseLoginView;

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
            switch (input) {
                case "1":
                    // 고객 접속
                    new MemberMenuView().menu(new MemberMenuView().MemberLogin());
                    break;
                case "2":
                    // 쇼핑몰 관리자 접속
                    new MallLoginView().mallLogin();
                    break;
                case "3":
                    new WarehouseLoginView().LoginView();
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
