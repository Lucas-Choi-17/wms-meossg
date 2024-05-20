package com.meossg.mall.controller;

import com.meossg.mall.model.dto.*;
import com.meossg.mall.model.service.MallService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MallController {

    private MallService mallService = new MallService();

    public static void addProduct(ProductDTO product) {
        MallService.addProduct(product);
    }

    public static void modifyProduct(ProductDTO product) {
        int result = MallService.modifyProduct(product);

        if (result == 1) {
            System.out.println("상품 정보 변경 성공!!");
        } else {
            System.out.println("상품 정보 변경 실패!!");
        }
    }

    public static void placingOrder(Map<String, Integer> map) {

        if (map != null) {
            int result = MallService.placingOrder(map);

            if (result == 1) {
                System.out.println("발주 성공!!");
            } else {
                System.out.println("발주 실패!!");
            }
        }
    }

    public static int checkProductExists(int productId) {
        return MallService.checkProductExists(productId);
    }

    public static void getAllStockList() {
        List<StockDTO> stockList = MallService.getAllStockList();
        System.out.println("---------- < 재고 > ----------");
        for (StockDTO stock : stockList) {
            System.out.print("ID : %3s,  ".formatted(stock.getId()));
            System.out.print("NAME : %8s,  ".formatted(stock.getName()));
            System.out.println("COUNT : %4s".formatted(stock.getCount()));
        }
    }

    public AdminDTO login(AdminDTO admin) {

        return mallService.verifyLogin(admin);
    }

    public void selectAllMember() {
        List<MemberDTO> memberList = mallService.selectAllMember();

        for (MemberDTO member : memberList) {
            System.out.println(member);
        }
    }


    public void selectMemberByName(MemberDTO findName) {
        List<MemberDTO> memberList = mallService.selectMemberByName(findName);

        if (memberList.isEmpty()) {
            System.out.println(findName.getName() + "님이 존재하지 않습니다.");
        } else {
            for (MemberDTO member : memberList) {
                System.out.println(member);
            }
        }

    }


    public void getAllOrderList() {
        List<MallOrderDTO> orderList = mallService.getAllOrderList();

        if (orderList != null) {
            for (MallOrderDTO order : orderList) {
                System.out.print("주문번호 : %3s,  ".formatted(order.getOrderId()));
                System.out.print("주문자 : %8s,  ".formatted(order.getUserName()));
                System.out.print("제품 : %4s,  ".formatted(order.getProductName()));
                System.out.print("수량 : %4s,  ".formatted(order.getCount()));
                System.out.println("총액 : %4s".formatted(order.getTotalPrice()));
            }
        } else {
            System.out.println("주문 내역이 없습니다.");
        }
    }

    public void showPostStatus() {
        List<DeliveryDTO> deliveryList = mallService.showPostStatus();
        if (!deliveryList.isEmpty()) {
            for (DeliveryDTO delivery : deliveryList) {
                System.out.println(delivery);
            }
        } else {
            System.out.println("배송 내역이 없습니다.");
        }
    }

    public void approveOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------< 미 승인 주문 >-------");
        List<MallOrderDTO> orderList = mallService.getAllOrderListWithStatus();
        if (orderList == null) {
            System.out.println("미 승인 주문 내역이 없습니다.");
        } else {
            for (MallOrderDTO order : orderList) {
                System.out.print("주문번호 : %3s,  ".formatted(order.getOrderId()));
                System.out.print("주문자 : %8s,  ".formatted(order.getUserName()));
                System.out.print("상품명 : %4s,  ".formatted(order.getProductName()));
                System.out.print("수량 : %4s,  ".formatted(order.getCount()));
                System.out.println("총액 : %4s,  ".formatted(order.getTotalPrice()));
            }
            System.out.println("--------------------------");
            System.out.print("주문 번호를 입력하세요 : ");
            int orderId = sc.nextInt();
            for (MallOrderDTO order : orderList) {
                if (order.getOrderId() == orderId) {
                    mallService.approveOrder(orderId);
                    return;
                }
            }
            System.out.println("없는 주문 번호입니다.");
        }
    }

    public void updatePassword(Map<String, String> newPassword) {
        MemberDTO member = new MemberDTO();
        member.setId(newPassword.get("id"));
        member.setName(newPassword.get("name"));
        member.setPassword(newPassword.get("password"));

        if (mallService.updatePassword(member)) {
            System.out.println("회원정보 수정을 성공했습니다.");
        } else {
            System.out.println("회원정보 수정을 실패했습니다.");
        }
    }


    public void updatePhone(Map<String, String> newPhone) {
        MemberDTO member = new MemberDTO();
        member.setId(newPhone.get("id"));
        member.setName(newPhone.get("name"));
        member.setPhone(newPhone.get("phone"));

        if (mallService.updatePhone(member)) {
            System.out.println("회원정보 수정을 성공했습니다.");
        } else {
            System.out.println("회원정보 수정을 실패했습니다.");
        }
    }

    public void updateAddress(Map<String, String> newAddress) {
        MemberDTO member = new MemberDTO();
        member.setId(newAddress.get("id"));
        member.setName(newAddress.get("name"));
        member.setAddress(newAddress.get("address"));

        if (mallService.updateAddress(member)) {
            System.out.println("회원정보 수정을 성공했습니다.");
        } else {
            System.out.println("회원정보 수정을 실패했습니다.");
        }
    }


    public void updateAllInfo(Map<String, String> newAllInfo) {
        MemberDTO member = new MemberDTO();
        member.setId(newAllInfo.get("id"));
        member.setName(newAllInfo.get("name"));
        member.setPassword(newAllInfo.get("password"));
        member.setPhone(newAllInfo.get("phone"));
        member.setAddress(newAllInfo.get("address"));

        if (mallService.updateAllInfo(member)) {
            System.out.println("회원정보 수정을 성공했습니다.");
        } else {
            System.out.println("회원정보 수정을 실패했습니다.");
        }
    }

    public void getTotalProfit() {
        System.out.println("----------< 전체 기간 수익 >----------");
        System.out.println(mallService.getTotalProfit());
    }
}


