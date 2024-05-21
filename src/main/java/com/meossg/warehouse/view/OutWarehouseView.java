package com.meossg.warehouse.view;

import com.meossg.warehouse.controller.OutWarehouseController;
import com.meossg.warehouse.model.dto.OrderListDTO;
import com.meossg.warehouse.model.dto.OutwarehouseDTO;
import com.meossg.warehouse.model.dto.PlacingOrderDTO;

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
            return;
        }

        System.out.println("출고 완료하였습니다.");

    }

    public void printPlacingOrder() {

        List<PlacingOrderDTO> orderList;

        orderList = oc.selectAllPlacingOrder();

        if (orderList != null) {
            System.out.println("===== 발주 목록 =====");
            for (PlacingOrderDTO order : orderList) {
                System.out.println("입고번호 : " + order.getId()
                                           + ", 상품 : " + order.getName()
                                           + ", 수량 : " + order.getCount()
                                           + ", 요청일 : " + order.getOrderDate()
                                           + ", 입고여부 : " + order.getInwarehouseyn()
                );
                System.out.println("===================");
            }
        } else {
            System.out.println("발주 목록이 없습니다.");
        }
    }

    public void printOutwarehouseList() {

        List<OutwarehouseDTO> shiplist;

        shiplist = oc.selectAllOutwarehouse();

        if (shiplist != null) {
            System.out.println("===== 출고 목록 =====");
            for (OutwarehouseDTO ship : shiplist) {
                System.out.println("출고번호 : " + ship.getId()
                                           + ", 주문번호 : " + ship.getOrderNumber()
                                           + ", 상품 : " + ship.getName()
                                           + ", 요청일 : " + ship.getOutDate()
                                           + ", 주소 : " + ship.getAddress()
                );
                System.out.println("===================");
            }
        } else {
            System.out.println("출고 목록이 없습니다.");
        }
    }
}
