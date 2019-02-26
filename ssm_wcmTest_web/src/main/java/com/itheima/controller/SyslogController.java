package com.itheima.controller;


import com.itheima.domain.Syslog;
import com.itheima.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/syslog")
public class SyslogController {
    @Autowired

    private  SyslogService syslogService;
    @RequestMapping("/findAll")
    public String  findAll(Model model)throws Exception{
        List<Syslog> list = syslogService.findAll();
        model.addAttribute( "sysLogs" ,list);
        return "syslog-list";
    }

}
