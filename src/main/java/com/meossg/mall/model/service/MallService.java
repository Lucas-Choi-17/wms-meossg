package com.meossg.mall.model.service;

import com.meossg.mall.model.dao.AdminMapper;
import com.meossg.mall.model.dao.ProductMapper;
import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.mall.model.dto.MemberDTO;
import com.meossg.mall.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class MallService {

    private AdminMapper adminMapper;

    public static void addProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.addProduct(product);
        if (result > 0) {
            System.out.println("상품 등록 성공!!");
            sqlSession.commit();
        } else {
            System.out.println("상품 등록 실패!!");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

    public static int modifyProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        try {
            int result = productMapper.modifyProduct(product);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public AdminDTO verifyLogin(AdminDTO admin) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
        AdminDTO adminDTO = adminMapper.verifyLogin(admin);

        sqlSession.close();
        return adminDTO;
    }

    public List<MemberDTO> selectAllMember() {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
        List<MemberDTO> memberList = adminMapper.selectAllMember();

        sqlSession.close();
        return memberList;
    }

    public boolean updateMemberInfo(MemberDTO member) {
        SqlSession sqlSession = getSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);

        int result = adminMapper.updateMemberInfo(member);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        return result>0;
    }
}


