package com.meossg.mall.controller;

import com.meossg.mall.model.dto.*;
import com.meossg.mall.model.service.MallService;

import java.util.List;
import java.util.Map;

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


    public void updateMember(Map<String, String> updateInfo) {
        MemberDTO member = new MemberDTO();
        member.setName(updateInfo.get("name"));
        System.out.println(updateInfo.get("name"));
        member.setPhone(updateInfo.get("phone"));
        System.out.println(updateInfo.get("phone"));
        member.setAddress(updateInfo.get("address"));
        System.out.println(updateInfo.get("address"));

        if (mallService.updateMemberInfo(member)) {
            System.out.println("회원정보 수정을 성공했습니다.");
        } else {
            System.out.println("회원정보 수정을 실패했습니다.");
        }

    }

    public void getAllOrderList() {
        List<OrderDTO> orderList = mallService.getAllOrderList();

        if (orderList != null) {
            for (OrderDTO order : orderList) {
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
}
