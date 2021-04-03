package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.entity.Category;
import com.wzvtc.minishop.repository.CategoryRepository;
import com.wzvtc.minishop.repository.SubCategoryRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @GetMapping("/list")
    public JSONResult selectCategoryAll(){
        return JSONResult.build(1,"",categoryRepository.findAll());
    }

    @GetMapping("/sublist")
    public JSONResult selectSubCategoryAll(Integer category_id){
        return JSONResult.build(1,"",subCategoryRepository.findSubCategoriesByCategoryId(category_id));
    }
}
