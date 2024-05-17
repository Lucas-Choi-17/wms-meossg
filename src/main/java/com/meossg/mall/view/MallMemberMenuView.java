package com.meossg.mall.view;

import com.meossg.mall.controller.MallController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MallMemberMenuView {
    MallController control = new MallController();
    public void memberManageMenu(){
        String memberMenu = ("""
                ================
                회원 관리
                ----------------
                1. 회원 정보 조회
                2. 회원 정보 수정
                0. 이전 메뉴로 돌아가기
                ----------------
                ================""");
        while (true) {
            System.out.println(memberMenu);
            System.out.print("메뉴를 선택해 주세요 : ");
            String choice = (new Scanner(System.in).nextLine().charAt(0))+"";

            switch (choice){
                case "1" :
                    control.selectAllMember();
                    break;
                case "2" :
                    control.updateMember(inputInfo());
                    break;
                case "0" :
                    System.out.println("잘못된 입력입니다.");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");

            }
        }

    }


    private Map<String, String> inputInfo () {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("메뉴 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }
}
