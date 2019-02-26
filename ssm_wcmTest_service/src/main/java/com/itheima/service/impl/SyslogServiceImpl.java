package com.itheima.service.impl;

import com.itheima.domain.Syslog;
import com.itheima.mapper.SyslogMapper;
import com.itheima.service.SyslogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogMapper syslogMapper;
    @Override
    public List<Syslog> findAll() throws Exception {
        return syslogMapper.findAll();
    }

    @Override
    public void saveSyslog(Syslog syslog) throws Exception {
        syslogMapper.saveSyslog(syslog);
    }



}
