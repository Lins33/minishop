package com.wzvtc.minishop.service;

import com.wzvtc.minishop.entity.Product;
import com.wzvtc.minishop.repository.ProductRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public JSONResult selectBySub(Integer subCategoryId){
        Optional<List<Product>> data=productRepository.findProductsBySubCategoryId(subCategoryId);
        return data.map(products -> JSONResult.build(1, "", products)).orElseGet(()->JSONResult.error("小类商品列表不存在"));
    }


    public JSONResult selectById(Integer id){
        Optional<Product> data=productRepository.findById(id);
        if(data.isPresent()){
            return JSONResult.build(1,"",data);
        }else {
            return JSONResult.error("商品不存在");
        }
    }
}
