package com.meossg.mall.view;

import com.meossg.mall.controller.mallController;
import com.meossg.mall.model.dto.AdminDTO;

import java.util.Scanner;

public class MallLoginView {

    public void mallLogin() {

        Scanner sc = new Scanner(System.in);
        mallController mallController = new mallController();

        System.out.print("ID : ");
        String id = sc.nextLine();
        System.out.print("Password : ");
        String password = sc.nextLine();

        AdminDTO admin = new AdminDTO();
        admin.setId(id);
        admin.setPassword(password);

        AdminDTO adminDTO = mallController.login(admin);

        if (adminDTO != null) {
            System.out.println(adminDTO.getName() + "님 로그인에 성공하였습니다.");
            new MallMenuView().mallMenu(adminDTO);
        } else {
            System.out.println("로그인에 실패하였습니다.");
        }
    }
}
