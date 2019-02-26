package com.itheima.controller;


import com.itheima.domain.Syslog;
import com.itheima.service.SyslogService;

import com.itheima.utils.ExcelUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

import java.util.List;

@Controller
@RequestMapping("/excel")
public class ReportFormController  {
   @Autowired
    private SyslogService syslogService;
    @RequestMapping("/sysLog")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Syslog> list = syslogService.findAll();

        //excel标题
        String[] title = {"ID","访问IP","访问方法","资源URL","访问名称"};

         //excel文件名
        String fileName = "日志管理"+System.currentTimeMillis()+".xls";


        //sheet名
        String sheetName = "日志表";


        String[][] content = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Syslog obj = list.get(i);
            content[i][0] = obj.getId();
            content[i][1] = obj.getIp();
            content[i][2] = obj.getMethod();
            content[i][3] = obj.getUrl();
            content[i][4] = obj.getUsername();

        }

        //创建HSSFWorkbook
       HSSFWorkbook wb=ExcelUtil.getHSSFWorkbook( sheetName,title,content,null );

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
       } catch (Exception e) {
       e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
