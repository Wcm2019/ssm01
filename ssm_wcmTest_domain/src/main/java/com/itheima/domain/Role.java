package com.itheima.domain;

import org.springframework.security.core.userdetails.User;

import java.io.Serializable;

import java.util.List;

public class Role implements Serializable{
    private String id;
    private String roleName;
    private String roleDesc;
    //角色和权限的关联关系
    private List<Permission> permissions;
    private List<User> users;
    //设置一个权限吗的标识 1为启用，0为未启用
    private int flag;

    public int getFlag() {

        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
