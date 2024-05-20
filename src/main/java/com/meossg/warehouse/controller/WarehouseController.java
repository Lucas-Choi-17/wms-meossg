package com.meossg.warehouse.controller;

import com.meossg.warehouse.model.dto.InWarehouseDTO;
import com.meossg.warehouse.model.dto.WhStockDTO;
import com.meossg.warehouse.model.service.InWarehouseService;
import com.meossg.warehouse.model.service.WarehouseService;
import com.meossg.warehouse.view.OutWarehouseView;

import java.util.List;

public class WarehouseController {

    WarehouseService ws = new WarehouseService();
    OutWarehouseView ov = new OutWarehouseView();

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

    public WhStockDTO selectStockByName(String name) {
        return ws.selectStockByName(name);
    }

    public List<WhStockDTO> selectAllStock() {
        return ws.selectAllStock();
    }

    public void inwarehouse(int id) {

        if (!ws.verifyPlacingOrder(id)) {
            System.out.println("존재하지 않는 발주번호입니다 !!");
            return;
        }


        if (ws.updateInwarehouseYn(id) <= 0) {
            System.out.println("입고 상태 변환에 실패했습니다 !!");
            return;
        }

        if (ws.updateStockCount(id) <= 0) {
            System.out.println("입고에 실패했습니다 !!");
        }

        if (ws.insertInWarehouse(id) <= 0) {
            System.out.println("입고 내역 저장에 실패했습니다.");
        }

    }
}
