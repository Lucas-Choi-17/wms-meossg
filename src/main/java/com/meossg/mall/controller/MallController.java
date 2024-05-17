package com.meossg.mall.controller;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.mall.model.service.MallService;

public class MallController {

    private MallService mallService = new MallService();

    public AdminDTO login(AdminDTO admin) {

        return mallService.verifyLogin(admin);
    }
}
