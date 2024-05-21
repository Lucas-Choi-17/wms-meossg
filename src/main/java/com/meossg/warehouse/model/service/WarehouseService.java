package com.meossg.warehouse.model.service;

import com.meossg.warehouse.model.dto.*;
import com.meossg.warehouse.model.mapper.WarehouseMapper;
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

    public MemberOrderDTO selectOrder(int id) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        MemberOrderDTO order = warehouseMapper.selectOrder(id);
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

        sqlSession.close();
        return shipStatus;
    }

    public List<PlacingOrderDTO> selectAllPlacingOrder() {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        List<PlacingOrderDTO> list = warehouseMapper.selectAllPlacingOrder();

        sqlSession.close();
        return list;
    }

    public List<OutwarehouseDTO> selectAllOutwarehouse() {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        List<OutwarehouseDTO> list = warehouseMapper.selectAllOutwarehouse();

        sqlSession.close();
        return list;
    }

    public WhStockDTO selectStockByName(String name) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        WhStockDTO stock = warehouseMapper.selectStockByName(name);

        sqlSession.close();
        return stock;
    }

    public List<WhStockDTO> selectAllStock() {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        List<WhStockDTO> list = warehouseMapper.selectAllStock();

        sqlSession.close();
        return list;
    }

//    public boolean verifyPlacingOrder(int id) {
//
//        SqlSession sqlSession = getSqlSession();
//        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
//        Integer result = warehouseMapper.verifyPlacingOrder(id);
//
//        sqlSession.close();
//        return result != null? true : false;
//    }

//    public int updateInwarehouseYn(int id) {
//
//        SqlSession sqlSession = getSqlSession();
//        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
//        int result = warehouseMapper.updateInwarehouseYn(id);
//
//        sqlSession.close();
//        return result;
//    }

//    public int updateStockCount(int id) {
//
//        SqlSession sqlSession = getSqlSession();
//        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
//        int result = warehouseMapper.updateStockCount(id);
//
//        sqlSession.close();
//        return result;
//    }

//    public int insertInWarehouse(int id) {
//
//        SqlSession sqlSession = getSqlSession();
//        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
//        int result = warehouseMapper.insertInWarehouse(id);
//
//        sqlSession.close();
//        return result;
//    }

    public boolean inwarehouse(int id) {

        boolean sqlStatus = true;

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        Integer result = warehouseMapper.verifyPlacingOrder(id);

        if( result == null){
            sqlStatus = false;
            result = 0;
            System.out.println("해당하는 발주번호가 존재하지않습니다.");
        }

        if (sqlStatus == true) {
            result = warehouseMapper.updateInwarehouseYn(id);
        }

        if (result <= 0){
            sqlStatus = false;
            System.out.println("입고상태변경에 실패했습니다.");
        }


        if (sqlStatus == true) {
            result = warehouseMapper.updateStockCount(id);
        }

        if(result <= 0){
            sqlStatus = false;
            System.out.println("재고 변경에 실패했습니다.");
        }


        if (sqlStatus == true) {
            result = warehouseMapper.insertInWarehouse(id);
        }

        if(result <= 0){
            sqlStatus = false;
            System.out.println("입고이력 생성에 실패했습니다.");
        }

        if (sqlStatus == true) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }


        sqlSession.close();

        return sqlStatus;
    }
}
