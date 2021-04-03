package com.wzvtc.minishop.repository;

import com.wzvtc.minishop.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
    List<SubCategory> findSubCategoriesByCategoryId(Integer id);
}
