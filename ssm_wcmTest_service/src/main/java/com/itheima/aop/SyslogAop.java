package com.itheima.aop;

import com.itheima.domain.Syslog;
import com.itheima.service.SyslogService;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.lang.annotation.Annotation;
import java.util.Date;

public class SyslogAop {

    @Autowired
    private  SyslogService syslogService;

    @Autowired
    private HttpServletRequest request;

    public void beforeMethod() throws Exception{
        System.out.println("before");
    }
    public void afterMethod(JoinPoint joinpoint)throws Exception{

        String methodName = joinpoint.getSignature().getName();




        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        String username = userDetails.getUsername();
        String ip = request.getRemoteAddr();




        System.out.println("after");
        Syslog syslog =new Syslog();
        syslog.setVisitTime( new Date(  ) );
        syslog.setUsername( username );
        syslog.setIp( ip );
        syslog.setUrl(""  );
        syslog.setMethod(methodName);
        syslog.setExecutionTime( 1L );
        syslogService.saveSyslog(syslog);
    }
}
