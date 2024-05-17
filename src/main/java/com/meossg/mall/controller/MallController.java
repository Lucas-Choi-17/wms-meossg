package com.meossg.mall.controller;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.mall.model.dto.ProductDTO;
import com.meossg.mall.model.dto.MemberDTO;
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
}
