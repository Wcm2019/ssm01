package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController implements Serializable {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                          @RequestParam(name = "size",required = true,defaultValue = "4")int size,
                          Model model) throws Exception{

        List<Product> all = productService.findAll(page,size);
        //pageinfo是一个分页bean
        PageInfo pageInfo=new PageInfo( all );
        model.addAttribute( "productList",all );
        model.addAttribute( "pageInfo",pageInfo );
        model.addAttribute( "product-page-list" );
        return "product-list";

    }
    @RequestMapping("/save")
    public String save(Product product)throws Exception{
        productService.save( product );
        return "redirect:/product/findAll";
    }
    @RequestMapping("/delete")
    public String delete(String[]ids ) throws Exception{
        productService.deltete(ids);
        return "redirect:/product/findAll";
    }
    @RequestMapping("/findBySerach")
    public String findBySerach(Product product,Model model) throws Exception{
        List<Product> bySerach = productService.findBySerach( product );
        model.addAttribute( "findBySearch",bySerach );
        return "/product";
    }
}
