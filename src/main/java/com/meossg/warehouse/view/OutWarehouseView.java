package com.meossg.warehouse.view;

import com.meossg.warehouse.controller.OutWarehouseController;
import com.meossg.warehouse.model.dto.OrderListDTO;

import java.util.List;
import java.util.Scanner;

public class OutWarehouseView {

    OutWarehouseController oc = new OutWarehouseController();
    Scanner sc = new Scanner(System.in);
    public void printOrderList() {

        List<OrderListDTO> orderList;

        orderList = oc.selectAllOrderList();

        if (orderList != null) {
            System.out.println("===== 주문 목록 =====");
            for (OrderListDTO order : orderList) {
                System.out.println("주문번호 : " + order.getOrderId()
                                           + ", 상품 : " + order.getName()
                                           + ", 수량 : " + order.getCount());
            }
            System.out.println("===================");
        } else {
            System.out.println("출고 가능한 주문이 없습니다 !!");
            return;
        }

        int selOrderId;

        System.out.print("출고하실 주문번호를 입력하세요 : ");
        selOrderId = sc.nextInt();
        sc.nextLine();

        if (!oc.shipOrder(selOrderId)) {

            System.out.println("출고 실패하였습니다.");
        }

        System.out.println("출고 완료하였습니다.");

    }
}
