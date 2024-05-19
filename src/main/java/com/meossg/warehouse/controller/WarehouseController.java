package com.meossg.warehouse.controller;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.warehouse.model.dto.InWarehouseDTO;
import com.meossg.warehouse.model.dto.WhAdminDTO;
import com.meossg.warehouse.model.service.InWarehouseService;
import com.meossg.warehouse.model.service.WarehouseService;

import java.util.List;

public class WarehouseController {

    WarehouseService ws = new WarehouseService();
    public static void getInWarehouse() {
        List<InWarehouseDTO> inWarehouseDTOList = InWarehouseService.getAllInWarehouseList();
        System.out.println("--------------창고--------------");
        for (InWarehouseDTO inWarehouseDTO : inWarehouseDTOList) {
            System.out.println("입고번호 : " + inWarehouseDTO.getId());
            System.out.println("상품번호 : " + inWarehouseDTO.getProductId());
            System.out.println("입고일 : " + inWarehouseDTO.getInDate());
        }
    }

    public boolean login(String id, String pwd) {

        return ws.verifyLogin(id,pwd);
    }
}
