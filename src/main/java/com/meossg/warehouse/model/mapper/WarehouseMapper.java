package com.meossg.warehouse.model.mapper;

import com.meossg.warehouse.model.dto.*;

import java.util.List;

public interface WarehouseMapper {
    List<InWarehouseDTO> getAllInWarehouseList();
    WhAdminDTO getUser(String id);

    List<OrderListDTO> selectAllOrderList();

    MemberOrderDTO selectOrder(int id);

    Integer verifyStock(int id);

    int insertOutWarehouse(int id);

    int updateDeliveryn(int id);

    int updateTblDelivery(int id);

    int updateStock(int id);

    List<PlacingOrderDTO> selectAllPlacingOrder();

    List<OutwarehouseDTO> selectAllOutwarehouse();

    WhStockDTO selectStockByName(String name);
}
