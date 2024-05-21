package com.meossg.member.model.dao;

import com.meossg.member.model.dto.ItemDTO;
import com.meossg.member.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberMapperTest {

    SqlSession sqlSession;
    MemberMapper memberMapper;

    @BeforeEach
    void setUp() throws Exception {
        this.sqlSession = getSqlSession();
        this.memberMapper = sqlSession.getMapper(MemberMapper.class);
    }

    @AfterEach
    void tearDown() throws Exception {
        sqlSession.rollback();
        sqlSession.close();
    }

    @DisplayName("회원 Insert 쿼리 테스트 코드")
    @Test
    void signUp() {

        String id = "99", password = "11", name = "name", phone = "testtest", address = "쿠차라 삼성역점";

        UserDTO user = new UserDTO(id, password, name, phone, address);

        int result = memberMapper.signUp(user);

        assertThat(result).isEqualTo(1);
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPhone()).isEqualTo(phone);
        assertThat(user.getAddress()).isEqualTo(address);
    }

    @DisplayName("회원 Update 쿼리 테스트 코드")
    @Test
    void modifyInfo() {
        String id = "codeTest", password = "11", name = "쿠차라 코엑스", phone = "02-3466-8558", address = "서울특별시 강남구 테헤란로87길 46";

        UserDTO user = new UserDTO(id, name, phone, address, password);

        int result = memberMapper.modifyInfo(user);

        assertThat(result).isEqualTo(1);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPhone()).isEqualTo(phone);
        assertThat(user.getAddress()).isEqualTo(address);
    }

    
    @DisplayName("회원 Select 쿼리 테스트 코드")
    @Test
    void selectAllProducts() {
        List<ItemDTO> productList = memberMapper.selectAllProducts();

        for (ItemDTO product : productList) {
            System.out.println(product);
        }

        assertThat(productList).isNotNull();
        assertThat(productList.get(0).getId()).isEqualTo(1);
        assertThat(productList.get(1).getId()).isEqualTo(2);
        assertThat(productList.get(2).getId()).isEqualTo(3);
    }
}