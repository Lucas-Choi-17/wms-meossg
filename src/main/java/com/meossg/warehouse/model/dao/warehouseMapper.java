package com.meossg.warehouse.model.dao;

import com.meossg.warehouse.model.dto.InWarehouseDTO;

import java.util.List;

public interface warehouseMapper {
    List<InWarehouseDTO> getAllInWarehouseList();
}
