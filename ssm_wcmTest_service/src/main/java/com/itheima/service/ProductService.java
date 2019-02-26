package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService  {
    List<Product>findAll(int page, int size) throws Exception;
    void save(Product product) throws Exception;

    void deltete(String[] ids)throws Exception;

    List<Product> findBySerach(Product product) throws Exception;
}
