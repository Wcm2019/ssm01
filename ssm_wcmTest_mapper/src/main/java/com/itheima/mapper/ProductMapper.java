package com.itheima.mapper;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAll(int page,int size) throws   Exception;
    void save(Product product) throws Exception;

    void delete(String[] ids);

    List<Product> findBySerach(Product product);
}
