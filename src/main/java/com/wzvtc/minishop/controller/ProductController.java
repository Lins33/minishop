package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.service.ProductService;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public JSONResult selectAllBySubCategory(Integer subCategoryId){
        return productService.selectBySub(subCategoryId);
    }


    @GetMapping("/detail")
    public JSONResult selectById(Integer id){
        return productService.selectById(id);
    }
}
