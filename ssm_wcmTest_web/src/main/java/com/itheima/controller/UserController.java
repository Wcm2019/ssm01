package com.itheima.controller;


import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll")
    public String findAll(Model model)throws Exception{
        List<UserInfo> list = userService.findAll();
        model.addAttribute( "userList",list );
        return "user-list";
    }
    //根据ID 查询当前用户信息
    @RequestMapping("/findById")
    public String findById(String uid,Model model)throws Exception{
        UserInfo userInfo=userService.findById(uid);
        model.addAttribute("user",userInfo );
        return "user-show";
    }
    //根据用户ID 查询角色信息
    @RequestMapping("/findRolesByUid")
    public String findRolesByUid(String uid,Model model) throws Exception{
        //当前用户所拥有的角色
        List<Role> roleByUserId = roleService.findRolesByUid( uid );
        //所有的角色
        List<Role>roleList=roleService.findAll();
        for(Role role:roleList){
            for(Role userRole:roleByUserId){
                if((role.getId()).equals( userRole.getId() )){
                    role.setFlag( 1 );
                }
            }

        }
        model.addAttribute( "uid",uid );
        model.addAttribute( "roleList",roleList);
        return "user-role-add";
    }
    //更改用户角色
    @RequestMapping("/updateUserRoles")
    public String updateUserRoles(String userId,String ids)throws Exception{

        userService.updateUserRoles(userId,ids);

        return "redirect:/user/findAll";
    }
}
