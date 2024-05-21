package com.meossg.mall.model.service;

import com.meossg.mall.model.dao.ProductMapper;
import com.meossg.mall.model.dto.ProductDTO;
import com.meossg.mall.model.dto.SalesRateDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
class MallServiceTest {

    @DisplayName("쇼핑몰 CRUD 중 Create 기능 테스트")
    @Test
    void addProductTest() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        int result = productMapper.addProduct(new ProductDTO(100,"Test",10000,"대", "BLACK","Y"));
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쇼핑몰 CRUD 중 Delete 기능 테스트")
    @Test
    void deletePlacingOrderTest() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("id", 1);
        int result = productMapper.deletePlacingOrder(map);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쇼핑몰 CRUD 중 Update 기능 테스트")
    @Test
    void modifyProduct() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        int result = productMapper.modifyProduct(new ProductDTO(2,"Test",10000,"대", "BLACK","Y"));
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쇼핑몰 CRUD 중 Select 기능 테스트")
    @Test
    void selectTotalSalesRate() {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        List<SalesRateDTO> salesRateList = productMapper.salesTotalSalesRate();

        assertThat(salesRateList).isNotNull();
    }
}