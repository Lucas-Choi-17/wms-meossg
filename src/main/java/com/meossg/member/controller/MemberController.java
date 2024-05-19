package com.meossg.member.controller;

import com.meossg.member.model.dto.UserDTO;
import com.meossg.member.model.service.MemberService;
import com.meossg.member.view.MemberLoginView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {

    public long nonMemberIdx = 0;
    public UserDTO loginMember;

    public List<UserDTO> memberList = new ArrayList<>();

    public UserDTO signIn() {
        Scanner sc = new Scanner(System.in);
        loginMember = new UserDTO();

        System.out.println("\n1. 로그인을 선택했습니다.");
        System.out.println("아이디와 비밀번호를 입력하세요");

        System.out.print("[아이디] 😍 : ");
        loginMember.setId(sc.nextLine());
        System.out.print("[비밀번호] 😊 : ");
        loginMember.setPassword(sc.nextLine());

        UserDTO user = MemberService.userValidCheck(loginMember);
        if (user == null) {
            System.out.println("아이디와 패스워드가 틀렸습니다.😢");
            return null;
        }

        loginMember = user;
        return loginMember;
    }

    public UserDTO bsignIn() {
        System.out.println("\n2. 비회원 로그인을 선택했습니다.");
        nonMemberIdx++;
        loginMember = new UserDTO("tmpuser" + nonMemberIdx, "", "임시회원");
        return loginMember;
    }

    public void signUp() {
        Scanner sc = new Scanner(System.in);
        loginMember = new UserDTO();

        System.out.println("\n3. 회원가입을 선택했습니다.");
        System.out.println("회원가입을 위해 아래의 정보를 입력해 주세요.");
        System.out.print("[아이디] : ");
        loginMember.setId(sc.nextLine());
        System.out.print("[비밀번호] : ");
        loginMember.setPassword(sc.nextLine());
        System.out.print("[이름] : ");
        loginMember.setName(sc.nextLine());
        System.out.print("[전화번호] : ");
        loginMember.setPhone(sc.nextLine());
        System.out.print("[주소] : ");
        loginMember.setAddress(sc.nextLine());

//        if (isDupleId(loginMember)) {
//            System.out.println("\n아이디가 이미 존재합니다. 😮 (중복)");
//            return;
//        }
//        memberList.add(loginMember);

        MemberService.signUp(loginMember);

        System.out.println("\n회원가입이 완료되었습니다 🎉");
    }

    public UserDTO userValidCheck(UserDTO member) {  //사용자가 입력한 아이디와 비밀번호가 memberList에 저장된 회원 정보와 일치하는지 확인하는 메소드

        if (memberList.isEmpty()) return null;  //회원 목록이 비어있는지 확인

        for (UserDTO tmp : memberList) {    //회원 목록을 순회
            String tmpId = tmp.getId();
            String tmpPwd = tmp.getPassword();

            if (tmpId.equals(member.getId()) && tmpPwd.equals(member.getPassword())) {  //회원 목록내의 아이디와 비밀번호 일치 여부 확인
                return tmp;
            }
        }

        return null;   //일치하는 회원이 없는 경우 null 반환
    }

    public boolean isDupleId(UserDTO member) {

        for (UserDTO user : memberList) {
            String userId = user.getId();

            if (userId.equals(member.getId())) return true;
        }

        return false;
    }

    public void personalInquiry(UserDTO user){
        MemberService memberService = new MemberService();

        UserDTO member = memberService.personalInquiry(user);
        System.out.println(member.toString());

    }

    public void buy() {
        System.out.println("-------< 구매 가능 목록 >-------");
    }
}
