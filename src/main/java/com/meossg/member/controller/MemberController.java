package com.meossg.member.controller;

import com.meossg.member.model.dto.ItemDTO;
import com.meossg.member.model.dto.OrderPurchasedDTO;
import com.meossg.member.model.dto.UserDTO;
import com.meossg.member.model.service.MemberService;
import com.meossg.member.view.MemberMenuView;

import java.util.*;

public class MemberController {

    public long nonMemberIdx = 0;
    public UserDTO loginMember;

    public List<UserDTO> memberList = new ArrayList<>();

    private final PrintResult printResult;

    private final MemberService memberService;

    public MemberController(){
        printResult = new PrintResult();
        memberService = new MemberService();
    }

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

    public void personalInquiry(UserDTO user) {
        MemberService memberService = new MemberService();

        UserDTO member = memberService.personalInquiry(user);
        System.out.println(member.toString());

    }

    public void modifyInfo(Map<String,String> parameter) {  //회원이 자신의 개인정보수정
        PrintResult printResult = new PrintResult();
        String id = parameter.get("id");
        String phone = parameter.get("phone");
        String address = parameter.get("address");
        String password = parameter.get("password");

        UserDTO user = new UserDTO();
        user.setPhone(phone);
        user.setAddress(address);
        user.setPassword(password);
        user.setId(id);

        if (MemberService.modifyInfo(user)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void buy(String memberId) {
        MemberService memberService = new MemberService();
        Scanner sc = new Scanner(System.in);

        Map<String, Object> map = new HashMap<>();
        System.out.println("-------< 상품 구매 >-------");
        System.out.print("구매하려는 상품명을 입력하세요 : ");
        String productName = sc.nextLine();
        System.out.print("구매 수량을 입력하세요 : ");
        int count = sc.nextInt();

        map.put("memberId", memberId);
        map.put("productName", productName);
        map.put("count", count);

        memberService.buy(map);
    }

    public void selectAllProducts() {
        MemberService memberService = new MemberService();
        List<ItemDTO> productList = memberService.selectAllProducts();

        for (ItemDTO product : productList) {
            System.out.println(product);
        }
    }

    public void purchased(String memberId) {
        MemberService memberService = new MemberService();
        List<OrderPurchasedDTO> orderList = memberService.purchased(memberId);
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();

        if (orderList != null && orderList.size() > 0) {
            for (OrderPurchasedDTO order : orderList) {
                System.out.println(order.toString());
            }

            // 주문 선택 / 뒤로가기

            while (true) {
                System.out.println("사용할 번호를 선택해주세요");
                System.out.println("1. 주문 상품 선택 0.뒤로가기");
            int input = sc.nextInt();
            switch (input) {
                case 1: //주문한 상품 선택 / 주문 선택하면 해당 정보 출력
                    memberController.selectProductName(inputProductName());
                    break;
                case 0:
                   // 뒤로가기
                   return;
                default:
                    System.out.println("다시 입력해주셔요!");
                    break;
            }
        }

            // 정보 출력 후 해당 주문 취소하기 / 뒤로가기

            // 해당 주문 취소하는 경우, 배송 완료인 경우는 취소 불가
            // 배송 완료가 아닌 경우에는 주문 취소 -> DELIVERY에서 해당 정보 제거, MEMBER_ORDER에서 해당 ORDER_APPROVEYN 값을 null로 변경
        } else {
            System.out.println("주문 내역이 존재하지 않습니다.");
        }
    }

//    public static void main(String[] args) {
//        UserDTO user = new UserDTO("1", "얍떙", "bar", "foo", "11");
//        shopView(user);
//    }

    private Map<String, String> inputProductName() {

        Scanner sc = new Scanner(System.in);
        System.out.println("주문한 상품 이름을 입력하세요 : ");
        String name = sc.nextLine();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("name", name);

        return parameter;

    }

    public void selectProductName(Map<String,String> parameter){

        String name = parameter.get("name");

        ItemDTO item = MemberService.selectProductName(name);

        if(item != null) {
            printResult.printPurchased(item);
        }else {
            printResult.printErrorMessage("selectOne");
        }
    }

}
