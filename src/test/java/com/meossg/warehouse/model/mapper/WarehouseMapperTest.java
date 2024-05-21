package com.meossg.warehouse.model.mapper;

import com.meossg.warehouse.model.dto.OrderListDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class WarehouseMapperTest {

    SqlSession sqlSession;
    WarehouseMapper warehouseMapper;

    @BeforeEach
    void setUp() throws Exception {
        this.sqlSession = getSqlSession();
        this.warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
    }

    @AfterEach
    void tearDown() throws Exception {
        sqlSession.rollback();
        sqlSession.close();
    }


    @DisplayName("창고 select 쿼리 테스트 코드")
    @Test
    void selectAllOrderList() {

        List<OrderListDTO> orderList = warehouseMapper.selectAllOrderList();

        for (OrderListDTO orderListDTO : orderList) {
            System.out.println(orderListDTO);
        }

        assertThat(orderList).isNotNull();
    }

    
    @DisplayName("창고 insert 쿼리 테스트 코드")
    @Test
    void insertOutWarehouse() {

        int result = warehouseMapper.insertOutWarehouse(28);

        assertThat(result).isEqualTo(1);

    }

    @DisplayName("창고 update 쿼리 테스트 코드")
    @Test
    void updateInwarehouseYn() {
        int result = warehouseMapper.updateInwarehouseYn(8);

        assertThat(result).isEqualTo(1);
    }
}