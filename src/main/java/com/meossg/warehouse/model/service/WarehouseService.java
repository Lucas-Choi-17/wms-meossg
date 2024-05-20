package com.meossg.warehouse.model.service;

import com.meossg.warehouse.model.dao.WarehouseMapper;
import com.meossg.warehouse.model.dto.InWarehouseDTO;
import com.meossg.warehouse.model.dto.WhAdminDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class WarehouseService {

    private WarehouseMapper warehouseMapper;


    public boolean verifyLogin(String id, String pwd) {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        WhAdminDTO user = warehouseMapper.getUser(id);

        sqlSession.close();

        if(user == null)
            return false;

        if (user.getId().equals(id) && user.getPassword().equals(pwd)) {
            return true;
        }

        return false;
    }


}
