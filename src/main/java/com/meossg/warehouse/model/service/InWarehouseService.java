package com.meossg.warehouse.model.service;

import com.meossg.warehouse.model.dao.warehouseMapper;
import com.meossg.warehouse.model.dto.InWarehouseDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class InWarehouseService {

    public static List<InWarehouseDTO> getAllInWarehouseList() {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper warehouseMapper = sqlSession.getMapper(warehouseMapper.class);
        List<InWarehouseDTO> inWarehouseDTO = warehouseMapper.getAllInWarehouseList();

        sqlSession.close();
        return inWarehouseDTO;
    }

}
