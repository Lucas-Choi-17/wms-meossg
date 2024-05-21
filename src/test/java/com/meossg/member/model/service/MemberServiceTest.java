package com.meossg.member.model.service;

import com.meossg.member.model.dao.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import static com.meossg.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class MemberServiceTest {

    @Test
    void cancelOrder() {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

        int result = memberMapper.cancelOrder(10);

        assertThat(result).isEqualTo(1);
        sqlSession.close();
    }
}