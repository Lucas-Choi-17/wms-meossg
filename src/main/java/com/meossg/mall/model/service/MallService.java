package com.meossg.mall.model.service;

import com.meossg.mall.model.dao.AdminMapper;
import com.meossg.mall.model.dto.AdminDTO;
import org.apache.ibatis.session.SqlSession;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class MallService {

    public AdminDTO verifyLogin(AdminDTO admin) {
        SqlSession sqlSession = getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        AdminDTO adminDTO = adminMapper.verifyLogin(admin);

        sqlSession.close();
        return adminDTO;
    }
}
