package com.meossg.member.view;

import com.meossg.member.model.dto.UserDTO;
import com.meossg.member.controller.MemberController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberMenuView {

    public void menu(UserDTO member) {

        if (member.getId().contains("tmpuser")) {
            bMemberMenu(member);
        } else {
            memberMenu(member);
        }
    }

    public void bMemberMenu(UserDTO member) {
        MemberController memberController = new MemberController();
        Scanner sc = new Scanner(System.in);
        String menu = """
                ============================
                비회원 메뉴
                ============================
                1. 상품 조회
                0. 로그아웃
                ============================
                입력 :\s""";


        while (true) {
            System.out.println(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    memberController.selectAllProducts();
                    break;
                case 0:
                    // 로그아웃
                    System.out.println("로그아웃합니다.");
                    return;
                default:
                    System.out.println("다시 입력해!");
                    break;
            }
        }
    }

    public void memberMenu(UserDTO member) {
        Scanner sc = new Scanner(System.in);
        String menu = """
                ============================
                회원 메뉴
                ============================
                1. 개인정보 관리
                2. 쇼핑몰
                0. 로그아웃
                ============================
                입력 :\s""";
        while (true) {
            System.out.println(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    // 개인정보 관리
                    personalView(member);
                    break;
                case 2:
                    // 쇼핑몰
                    shopView(member);
                    break;
                case 0:
                    // 로그아웃
                    System.out.println("로그아웃합니다.");
                    return;
                default:
                    System.out.println("다시 입력해!");
                    break;
            }
        }
    }

    private void shopView(UserDTO member) {
        MemberController memberController = new MemberController();
        Scanner sc = new Scanner(System.in);
        String menu = """
                ============================
                쇼핑몰 메뉴
                ============================
                1. 상품 조회
                2. 상품 구매
                3. 장바구니
                0. 뒤로가기
                ============================
                입력 :\s""";

        while (true) {
            System.out.println(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    // 상품 조회
                    memberController.selectAllProducts();
                    break;
                case 2:
                    // 상품 구매
                    memberController.buy(member.getId());
                    break;
                case 3:
                    // 장바구니
                    break;
                case 0:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("다시 입력해!");
                    break;
            }
        }
    }

    private void personalView(UserDTO member) {
        MemberController memberController = new MemberController();
        Scanner sc = new Scanner(System.in);
        String menu = """
                ============================
                개인정보 관리 메뉴
                ============================
                1. 개인정보 조회
                2. 개인 정보 수정
                0. 뒤로가기
                ============================
                입력 :\s""";

        while (true) {
            System.out.println(menu);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    // 개인정보 조회
                    memberController.personalInquiry(member);
                    break;
                case 2:
                    // 개인정보 수정
                    memberController.modifyInfo(inputModifyMember(member));
                    break;
                case 0:
                    // 뒤로가기
                    return;
                default:
                    System.out.println("다시 입력해!");
                    break;
            }
        }
    }

    private static Map<String,String> inputModifyMember(UserDTO member){

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 핸드폰 번호를 입력하세요 ☎ : ");
        String phone = sc.nextLine();
        System.out.print("수정할 주소를 입력하세요 🏠 : ");
        String address = sc.nextLine();
        System.out.print("수정할 비밀번호를 입력하세요 🔓 : ");
        String password = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("phone",phone);
        parameter.put("address",address);
        parameter.put("password",password);
        parameter.put("id",member.getId());
        return parameter;
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
