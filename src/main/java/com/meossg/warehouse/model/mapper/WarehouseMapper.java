package com.meossg.warehouse.model.mapper;

import com.meossg.warehouse.model.dto.InWarehouseDTO;
import com.meossg.warehouse.model.dto.OrderDTO;
import com.meossg.warehouse.model.dto.OrderListDTO;
import com.meossg.warehouse.model.dto.WhAdminDTO;

import java.util.List;

public interface WarehouseMapper {
    List<InWarehouseDTO> getAllInWarehouseList();
    WhAdminDTO getUser(String id);

    List<OrderListDTO> selectAllOrderList();

    OrderDTO selectOrder(int id);

    Integer verifyStock(int id);

    int insertOutWarehouse(int id);

    int updateDeliveryn(int id);

    int updateTblDelivery(int id);

    int updateStock(int id);
}
