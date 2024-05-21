package com.meossg.member.model.service;

import com.meossg.member.model.dao.MemberMapper;
import com.meossg.member.model.dto.ItemDTO;
import com.meossg.member.model.dto.OrderPurchasedDTO;
import com.meossg.member.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        UserDTO user = memberMapper.userValidCheck(loginMember);
        sqlSession.close();
        if (user != null && user.getId() != null) {
            return user;
        } else {
            return null;
        }
    }

    public static boolean cancelOrder(int id) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

        int result = memberMapper.cancelOrder(id);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true:false;
    }

    public static String getDeliveryStatus(int id) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        String deliverYN = memberMapper.getDeliveryStatus(id);
        sqlSession.close();
        return deliverYN;

    }

    public UserDTO personalInquiry(UserDTO user) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        UserDTO member = memberMapper.personalInquiry(user);
        sqlSession.close();
        return member;
    }

    public static boolean modifyInfo(UserDTO user) {
        SqlSession sqlSession = getSqlSession();
        System.out.println("user ==================== " + user);
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        int result = memberMapper.modifyInfo(user);
        System.out.println("[MemberService] modifyInfo 의 result : " + result);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0 ? true : false;

    }

    public List<ItemDTO> selectAllProducts() {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

        List<ItemDTO> productList = memberMapper.selectAllProducts();

        return productList;
    }

    public void buy(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        int result = memberMapper.buy(map);

        if (result > 0) {
            sqlSession.commit();
            System.out.println("구매 성공!");
        } else {
            sqlSession.rollback();
            System.out.println("구매 실패!");
        }
        sqlSession.close();
    }

    public List<OrderPurchasedDTO> purchased(String memberId) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        List<OrderPurchasedDTO> orderList = memberMapper.purchased(memberId);
        if (orderList != null && orderList.size() > 0) {
            sqlSession.close();
            return orderList;
        } else {
            return null;
        }
    }

    public static ItemDTO selectProductName(String name){

        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

        ItemDTO item = memberMapper.selectProductName(name);

        sqlSession.close();
        return item;

    }
}
