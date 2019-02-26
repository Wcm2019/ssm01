package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;



public interface RoleService {
    List<Role> findRolesByUid(String uid)throws Exception;


    List<Role> findAll() throws Exception;
    List<Role>findRoleAll() throws  Exception;

}
