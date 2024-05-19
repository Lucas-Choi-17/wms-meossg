package com.meossg.member.model.dao;

import com.meossg.member.model.dto.UserDTO;

public interface MemberMapper {
    int signUp(UserDTO member);

    UserDTO userValidCheck(UserDTO loginMember);

    UserDTO personalInquiry(UserDTO user);
}
