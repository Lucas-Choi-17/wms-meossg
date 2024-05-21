package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class ProductMapperTest {

    SqlSession sqlSession;
    ProductMapper productMapper;

    @BeforeEach
    void setUp() throws Exception {
        this.sqlSession = getSqlSession();
        this.productMapper = sqlSession.getMapper(ProductMapper.class);
    }

    @AfterEach
    void tearDown() throws Exception {
        sqlSession.rollback();
        sqlSession.close();
    }

    @DisplayName("insert 문 쿼리 동작 테스트")
    @Test
    void addProduct() {

        Integer id = null, price = 77;
        String name = "테스트상품", size = "T", color = "BLACK", avail = "Y";

        ProductDTO productDTO = new ProductDTO(id,name,price,size,color,avail);

        int result = productMapper.addProduct(productDTO);

        assertThat(result).isEqualTo(1);
        assertThat(productDTO.getName()).isEqualTo(name);
        assertThat(productDTO.getPrice()).isEqualTo(price);
        assertThat(productDTO.getSize()).isEqualTo(size);
        assertThat(productDTO.getColor()).isEqualTo("BLACK");
    }

    
    @DisplayName("update 문 쿼리 동작 테스트 코드")
    @Test
    void modifyProduct() {

        int id = 22, price = 12345;
        String name = "업데이트 테스트상품", size = "L", color = "yellow", avail = "N";

        ProductDTO productDTO = new ProductDTO(id,name,price,size,color,avail);

        int result = productMapper.modifyProduct(productDTO);

        assertThat(result).isEqualTo(1);
        assertThat(productDTO.getId()).isEqualTo(id);
        assertThat(productDTO.getName()).isEqualTo(name);
        assertThat(productDTO.getPrice()).isEqualTo(price);
        assertThat(productDTO.getSize()).isEqualTo(size);
        assertThat(productDTO.getColor()).isEqualTo("yellow");
    }

    
    @DisplayName("상품 목록 조회하는 쿼리 연결 테스트")
    @Test
    void selectAllProducts() {
        List<ProductDTO> productList = productMapper.selectAllProducts();
        for (ProductDTO product : productList) {
            System.out.println(product);
        }

        assertThat(productList)
                .isNotNull();


    }

    @Test
    void deletePlacingOrder() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("id", 8);

        int result = productMapper.deletePlacingOrder(map);
        assertThat(result).isEqualTo(1);
    }

}