package com.itheima.mapper;

import com.itheima.domain.Member;

import java.util.List;

public interface MemberMapper {
    List<Member> all()throws Exception;
}
