package com.meossg.warehouse.model.service;

import com.meossg.warehouse.model.mapper.WarehouseMapper;
import com.meossg.warehouse.model.dto.InWarehouseDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class InWarehouseService {

    public static List<InWarehouseDTO> getAllInWarehouseList() {
        SqlSession sqlSession = getSqlSession();
        WarehouseMapper warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        List<InWarehouseDTO> inWarehouseDTO = warehouseMapper.getAllInWarehouseList();

        sqlSession.close();
        return inWarehouseDTO;
    }
}
