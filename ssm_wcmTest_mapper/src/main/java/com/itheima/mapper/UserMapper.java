package com.itheima.mapper;

import com.itheima.domain.UserInfo;
import com.itheima.domain.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserMapper {
    //根据用户查询
    UserInfo findUserByName(String username) throws Exception;
    //遍历
    List<UserInfo>findAll() throws Exception;

    UserInfo findById(String uid) throws Exception;

    void deleteUserRoles(String userId) throws Exception;

    void saveUserRoles(@Param( "userId" ) String userId, @Param( "roleId" ) String roleId)throws Exception;

}
