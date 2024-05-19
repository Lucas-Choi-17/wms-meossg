package com.meossg.member.view;

import com.meossg.member.model.dto.UserDTO;
import com.meossg.member.controller.MemberController;

import java.util.Scanner;

public class MemberMenuView {

    public void MemberMenu(UserDTO member) {

        MemberController memberController = new MemberController();
        Scanner sc = new Scanner(System.in);

        if (member != null) { // 회원 로그인 후 메뉴
            String menu = """
                    ============================
                    회원 메뉴
                    ============================
                    1. 개인정보조회
                    2. 상품 구매
                    3. 구매 상세 조회
                    0. 로그아웃
                    ============================
                    입력 :\s""";

            System.out.println(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    // 개인정보 조회1
                     memberController.personalInquiry(member);
                    break;
                case 2:
                    //상품 구매
                    break;
                case 3:
                    //구매 상세 조회
                    break;
                case 0:
                    // 로그아웃
                    System.out.println("로그아웃합니다.");
                    return;
                default:
                    System.out.println("다시 입력해!");
                    break;
            }
        } else { // 비회원 로그인 메뉴

        }
    }

    public UserDTO MemberLogin() {

        MemberController memberController = new MemberController();
        Scanner sc = new Scanner(System.in);
        UserDTO member;

        while (true) {
            System.out.println("\n\n 안녕하세요! 머쓱 (⊙_⊙;) 입니다.");
            System.out.println("사용할 메뉴를 선택해주세요");
            System.out.println("1. 로그인, 2: 비회원 로그인, 3: 회원가입");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // 로그인
                    member = memberController.signIn();
                    if (member != null) {
                        return member;
                    }
                    break;
                case 2:
                    // 비회원 로그인
                    member = memberController.bsignIn();
                    return member;
                case 3:
                    // 회원 가입
                    memberController.signUp();
                    break;
                default:
                    System.out.println("다시 입력해주세요");
            }
        }
    }
}
