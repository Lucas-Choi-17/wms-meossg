package com.meossg.mall.controller;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.mall.model.dto.MemberDTO;
import com.meossg.mall.model.service.MallService;

import java.util.List;
import java.util.Map;

public class MallController {

    private MallService mallService = new MallService();

    public AdminDTO login(AdminDTO admin) {

        return mallService.verifyLogin(admin);
    }

    public void selectAllMember() {
        List<MemberDTO> memberList = mallService.selectAllMember();

        for (MemberDTO member : memberList) {
            System.out.println(member);
        }
    }


    public void updateMember(Map<String, String> stringStringMap) {
    }
}
