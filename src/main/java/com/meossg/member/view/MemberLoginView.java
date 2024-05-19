package com.meossg.member.view;

import com.meossg.member.model.dto.UserDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MemberLoginView {

    public long nonMemberIdx = 0;
    public UserDTO loginMember;

    public List<UserDTO> memberList = new ArrayList<>();
    public BufferedReader br;

    public UserDTO memberLogin() throws IOException {


        br = new BufferedReader(new InputStreamReader(System.in));

        int loginIdx = 0;

        Outer:
        while (true) {
            String userId = null;
            String userPwd = null;
            String userName = null;

            System.out.println("\n\n 안녕하세요! 머쓱 (⊙_⊙;) 입니다.");
            System.out.println("사용할 메뉴를 선택해주세요");
            System.out.println("1. 로그인, 2: 비회원 로그인, 3: 회원가입");

            loginIdx = Integer.parseInt(br.readLine());

            if (loginIdx == 1) {
                if (!signIn()) continue;

                while (true) {
                    System.out.println("1. 회원정보 조회, 2. 로그아웃");
                    loginIdx = Integer.parseInt(br.readLine());
                    if (loginIdx == 1) {
                        System.out.println(loginMember);
                    } else if (loginIdx == 2) {
                        continue Outer;
                    }
                }
            } else if (loginIdx == 2) {
                bsignIn();
                break;
            } else if (loginIdx == 3) {
                if (!signUp()) continue;
            }

        }

        System.out.println("\n[" + loginMember.getName() + "] 님 환영합니다. 로그인이 완료되었습니다.");

        return loginMember;
    }

    public boolean signIn() throws IOException {
        String userId = null;
        String userPwd = null;

        System.out.println("\n1. 로그인을 선택했습니다.");
        System.out.println("아이디와 비밀번호를 입력하세요");

        System.out.print("[아이디] 😍 : ");
        userId = br.readLine();
        System.out.print("[비밀번호] 😊 : ");
        userPwd = br.readLine();

        UserDTO user = userValidCheck(userId, userPwd);
        if (user == null) {
            System.out.println("아이디와 패스워드가 틀렸습니다.😢");
            return false;
        }

        loginMember = user;
        return true;
    }

    public void bsignIn() {
        System.out.println("\n2. 비회원 로그인을 선택했습니다.");
        nonMemberIdx++;
        loginMember = new UserDTO("tmpuser" + nonMemberIdx, "", "임시회원");
    }

    public boolean signUp() throws IOException {
        String userId = null;
        String userPwd = null;
        String userName = null;
        String userPhone = null;
        String userAddress = null;

        System.out.println("\n3. 회원가입을 선택했습니다.");
        System.out.println("회원가입을 위해 아래의 정보를 입력해 주세요.");
        System.out.print("[아이디] : ");
        userId = br.readLine();
        System.out.print("[비밀번호] : ");
        userPwd = br.readLine();
        System.out.print("[이름] : ");
        userName = br.readLine();
        System.out.print("[전화번호] : ");
        userPhone = br.readLine();
        System.out.print("[주소] : ");
        userAddress = br.readLine();

        if (isDupleId(userId)) {
            System.out.println("\n아이디가 이미 존재합니다. 😮 (중복)");
            return false;
        }

        UserDTO user = new UserDTO(userId, userPwd, userName, userPhone, userAddress);
        memberList.add(user);

        System.out.println("\n회원가입이 완료되었습니다 🎉");
        return true;
    }

    public UserDTO userValidCheck(String userId, String userPwd) {  //사용자가 입력한 아이디와 비밀번호가 memberList에 저장된 회원 정보와 일치하는지 확인하는 메소드

        if (memberList.isEmpty()) return null;  //회원 목록이 비어있는지 확인

        for (UserDTO tmp : memberList) {    //회원 목록을 순회
            String tmpId = tmp.getId();
            String tmpPwd = tmp.getPassword();

            if (tmpId.equals(userId) && tmpPwd.equals(userPwd)) {  //회원 목록내의 아이디와 비밀번호 일치 여부 확인
                return tmp;
            }
        }

        return null;   //일치하는 회원이 없는 경우 null 반환
    }

    public boolean isDupleId(String inputId) {

        for (UserDTO user : memberList) {
            String userId = user.getId();

            if (userId.equals(inputId)) return true;
        }

        return false;
    }
}
