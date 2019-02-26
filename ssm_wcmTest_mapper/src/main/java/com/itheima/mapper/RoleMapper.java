package com.itheima.mapper;


import com.itheima.domain.Role;


import java.util.List;

public interface RoleMapper {
    //根据用户id查询当前用户所拥有的角色


    List<Role> findRolesByUid(String uid) throws Exception;

    List<Role> findAll() throws Exception;

    List<Role> findRoleAll() throws  Exception;


}
