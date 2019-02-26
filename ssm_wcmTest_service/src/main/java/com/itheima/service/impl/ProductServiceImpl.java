package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        //pageNum是页码值  pageSize是个数
        PageHelper.startPage( page,size);
        return productMapper.findAll( page,size);

    }

    @Override
    public void save(Product product) throws Exception {
        productMapper.save( product );
    }

    @Override
    public void deltete(String[] ids) {
        productMapper.delete(ids);
    }

    @Override
    public List<Product> findBySerach(Product product) {

        return  productMapper.findBySerach(product);
    }
}
