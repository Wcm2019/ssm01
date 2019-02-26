package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrderMapper;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> findAll(int page, int size,String serachValue) throws Exception {
        //pageNum是页码值  pageSize是个数
        PageHelper.startPage( page,size);
        return orderMapper.findAll(serachValue);
    }

    @Override
    public Orders findById(String ordersId)throws Exception {
        return orderMapper.findById(ordersId);
    }
}
