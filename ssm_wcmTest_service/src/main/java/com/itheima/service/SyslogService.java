package com.itheima.service;

import com.itheima.domain.Syslog;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface SyslogService {
    List<Syslog>findAll() throws Exception;


    void saveSyslog(Syslog syslog)throws Exception;


}
