package com.meossg.member.model.service;

import com.meossg.member.model.dao.MemberMapper;
import com.meossg.member.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.meossg.common.MyBatisTemplate.getSqlSession;

public class MemberService {
    public static int signUp(UserDTO member) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        int result = memberMapper.signUp(member);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public static UserDTO userValidCheck(UserDTO loginMember) {
        SqlSession sqlSession= getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        UserDTO user = memberMapper.userValidCheck(loginMember);
        sqlSession.close();
        if (user.getId() != null) {
            return user;
        } else{
            return null;
        }
    }

    public UserDTO personalInquiry(UserDTO user) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        UserDTO member = memberMapper.personalInquiry(user);
        sqlSession.close();
        return member;
    }
}
