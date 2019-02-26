package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController implements Serializable{


    @Autowired
    private OrderService orderService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                          @RequestParam(name = "size",required = true,defaultValue = "2")int size,
                          String serachValue,Model model) throws Exception{

        List<Orders> list = orderService.findAll(page,size,serachValue);
        PageInfo pageInfo=new PageInfo( list );
        /*model.addAttribute( "ordersList",all );*/
        model.addAttribute( "pageInfo",pageInfo );
        /*model.addAttribute( "order-page-list" );*/
        return "orders-list";
    }
    @RequestMapping("/findById")
    public String findById(@RequestParam(name = "id",required = true) String ordersId ,
                           Model model )throws Exception{
        //id返回的是单个对象，不是返回集合。
         Orders orders =orderService.findById( ordersId );
        model.addAttribute( "orders",orders );
        return "orders-show";
    }
}
