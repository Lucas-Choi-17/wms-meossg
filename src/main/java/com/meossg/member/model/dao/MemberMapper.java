package com.meossg.member.model.dao;

import com.meossg.member.model.dto.ItemDTO;
import com.meossg.member.model.dto.UserDTO;

import java.util.Map;

import java.util.List;

public interface MemberMapper {
    int signUp(UserDTO member);

    UserDTO userValidCheck(UserDTO loginMember);

    UserDTO personalInquiry(UserDTO user);

    int modifyInfo(UserDTO user);

    int buy(Map<String, Object> map);

    List<ItemDTO> selectAllProducts();
}
