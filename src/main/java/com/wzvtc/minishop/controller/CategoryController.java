package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.Vo.CategoryVo;
import com.wzvtc.minishop.entity.Category;
import com.wzvtc.minishop.entity.SubCategory;
import com.wzvtc.minishop.repository.CategoryRepository;
import com.wzvtc.minishop.repository.SubCategoryRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @GetMapping("/category")
    public JSONResult selectCategoryAll(){
        List<CategoryVo> categoryVos=new ArrayList<>();
        List<Category> categories=categoryRepository.findAll();
        for(int i=0;i<categories.size();i++){
            List<SubCategory> subCategories =subCategoryRepository.findSubCategoriesByCategoryId(categories.get(i).getId());
            List<CategoryVo> subCategoryVoList=new ArrayList<>();
            for(int q=0;q<subCategories.size();q++){
                CategoryVo SubCategoryVo=new CategoryVo();
                SubCategory subCategory=subCategories.get(q);
                SubCategoryVo.setId(subCategory.getId());
                SubCategoryVo.setImage(subCategory.getImage());
                SubCategoryVo.setName(subCategory.getName());
                SubCategoryVo.setPid(subCategory.getCategory().getId());
                SubCategoryVo.setSub(null);
                subCategoryVoList.add(SubCategoryVo);
            }
            CategoryVo categoryVo=new CategoryVo();
            Category category=categories.get(i);
            categoryVo.setPid(0);
            categoryVo.setSub(subCategoryVoList);
            categoryVo.setName(category.getName());
            categoryVo.setId(categoryVo.getId());
            categoryVo.setImage("https://bkimg.cdn.bcebos.com/pic/37d12f2eb9389b503a80d4b38b35e5dde6116ed7?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2UxNTA=,g_7,xp_5,yp_5/format,f_auto");
            categoryVos.add(categoryVo);
        }
        return JSONResult.build(1,"",categoryVos);
    }

}
