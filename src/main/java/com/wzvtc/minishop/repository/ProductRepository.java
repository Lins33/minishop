package com.wzvtc.minishop.repository;

import com.wzvtc.minishop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<List<Product>> findProductsBySubCategoryId(Integer subCategoryId);


}
