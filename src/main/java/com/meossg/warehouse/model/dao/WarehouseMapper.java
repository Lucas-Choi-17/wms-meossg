package com.meossg.warehouse.model.dao;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.warehouse.model.dto.InWarehouseDTO;
import com.meossg.warehouse.model.dto.WhAdminDTO;

import java.util.List;

public interface WarehouseMapper {
    List<InWarehouseDTO> getAllInWarehouseList();
    WhAdminDTO getUser(String id);
}
