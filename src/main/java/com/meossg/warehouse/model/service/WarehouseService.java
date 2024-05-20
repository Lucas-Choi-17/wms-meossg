package com.meossg.warehouse.model.service;

import com.meossg.warehouse.model.mapper.WarehouseMapper;
import com.meossg.warehouse.model.dto.OrderDTO;
import com.meossg.warehouse.model.dto.OrderListDTO;
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

        if (user == null)
            return false;

        if (user.getId().equals(id) && user.getPassword().equals(pwd)) {
            return true;
        }

        return false;
    }

    public List<OrderListDTO> selectAllOrderList() {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        List<OrderListDTO> list = warehouseMapper.selectAllOrderList();

        sqlSession.close();

        return list;
    }

    public OrderDTO selectOrder(int id) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        OrderDTO order = warehouseMapper.selectOrder(id);
        sqlSession.close();

        return order;
    }

    public boolean verifyStock(int id) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        Integer verif = warehouseMapper.verifyStock(id);
        sqlSession.close();

        return verif != null;
    }

    public boolean shipping(int id) {

        boolean shipStatus = true;
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        int result = warehouseMapper.insertOutWarehouse(id);

        if (result <= 0) {
            System.out.println("<<ERR>> 출고 테이블 INSERT 에러 !!!");
            shipStatus = false;
        }

        result = warehouseMapper.updateStock(id);
        if (result <= 0) {
            System.out.println("<<ERR>> 스톡 테이블 UPDATE 에러 !!!");
            shipStatus = false;
        }

        result = warehouseMapper.updateDeliveryn(id);
        if (result <= 0) {
            System.out.println("<<ERR>> 오더 테이블 UPDATE 에러 !!!");
            shipStatus = false;
        }

        result = warehouseMapper.updateTblDelivery(id);
        if (result <= 0) {
            System.out.println("<<ERR>> 배송 테이블 UPDATE 에러 !!!");
            shipStatus = false;
        }

        if (shipStatus) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return shipStatus;
    }
}
