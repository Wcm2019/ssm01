package com.itheima.mapper;

import com.itheima.domain.Syslog;

import java.util.List;

public interface SyslogMapper {
    List<Syslog>findAll() throws Exception;

    void saveSyslog(Syslog syslog) throws Exception;
}
