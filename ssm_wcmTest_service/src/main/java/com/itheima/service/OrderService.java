package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrderService  {
    List<Orders> findAll(int page, int size,String serachValue) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
