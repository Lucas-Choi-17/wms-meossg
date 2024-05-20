package com.meossg.mall.model.dao;

import com.meossg.mall.model.dto.AdminDTO;
import com.meossg.mall.model.dto.MemberDTO;

import java.util.List;

public interface AdminMapper {


    AdminDTO verifyLogin(AdminDTO admin);

    List<MemberDTO> selectAllMember();

    int updateAllInfo(MemberDTO member);

    List<MemberDTO> selectMemberByName(MemberDTO findName);

    int updateMemberPassword(MemberDTO member);

    int updateMemberPhone(MemberDTO member);

    int updateMemberAddress(MemberDTO member);
}
