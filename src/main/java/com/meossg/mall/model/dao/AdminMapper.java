package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.mall.model.dto.MemberDTO;

import java.util.List;

public interface AdminMapper {


    AdminDTO verifyLogin(AdminDTO admin);

    List<MemberDTO> selectAllMember();

    int updateMemberInfo(MemberDTO member);
}
