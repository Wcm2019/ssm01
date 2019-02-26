package com.itheima.controller;


import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.domain.Users;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.server.UID;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @RequestMapping("/findRoleAll")
    public  String findAll(Model model)throws Exception{
        List<Role> roleList= roleService.findRoleAll();
        model.addAttribute( "roleList",roleList );
        return "role-user-list";
    }
    @RequestMapping("/findUserByRid")

    public String findById(String uid,Model model)throws Exception{
        UserInfo userInfo=userService.findById(uid);
        model.addAttribute("user",userInfo );
        return "role-show";
    }
}
