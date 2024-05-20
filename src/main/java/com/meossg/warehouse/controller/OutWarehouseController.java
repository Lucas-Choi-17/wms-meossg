package com.meossg.warehouse.controller;

import com.meossg.warehouse.model.dto.OrderListDTO;
import com.meossg.warehouse.model.dto.OutwarehouseDTO;
import com.meossg.warehouse.model.dto.PlacingOrderDTO;
import com.meossg.warehouse.model.service.WarehouseService;

import java.util.List;

public class OutWarehouseController {

    WarehouseService ws = new WarehouseService();
    public List<OrderListDTO> selectAllOrderList() {

        return ws.selectAllOrderList();
    }

    public boolean shipOrder(int id) {

        if (ws.selectOrder(id) == null) {
            System.out.println("유효한 주문번호가 아닙니다 !!");
            return false;
        }

        if (!ws.verifyStock(id)) {
            System.out.println("재고가 충분하지 않습니다 !!");
            return false;
        }

        if (!ws.shipping(id)) {
            return false;
        }

        return true;
    }

    public List<PlacingOrderDTO> selectAllPlacingOrder() {
        return ws.selectAllPlacingOrder();
    }

    public List<OutwarehouseDTO> selectAllOutwarehouse() { return ws.selectAllOutwarehouse();
    }
}
