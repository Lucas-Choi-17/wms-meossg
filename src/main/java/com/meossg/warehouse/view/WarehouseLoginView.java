package com.meossg.warehouse.view;

import com.meossg.mall.view.MallMenuView;
import com.meossg.warehouse.controller.WarehouseController;
import com.meossg.warehouse.model.dto.WhAdminDTO;

import java.util.Scanner;

public class WarehouseLoginView {
    WarehouseMenuView wm = new WarehouseMenuView();
    WarehouseController wc = new WarehouseController();
    WhAdminDTO user;
    Scanner sc = new Scanner(System.in);

    public void LoginView() {
        boolean loginYN = false;

        System.out.print("ID : ");
        String id = sc.nextLine();
        System.out.print("Password : ");
        String password = sc.nextLine();
        System.out.println(wc.login(id,password));

        if (wc.login(id,password)) {
            System.out.println(id + "님 로그인에 성공하였습니다.");
            wm.warehouseMenu();
        } else {
            System.out.println("로그인에 실패하였습니다.");
        }
    }

}
