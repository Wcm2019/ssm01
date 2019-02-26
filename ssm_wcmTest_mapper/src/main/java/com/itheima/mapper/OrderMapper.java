package com.itheima.mapper;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrderMapper {
    List<Orders> findAll(String serachValue) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
