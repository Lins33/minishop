package com.wzvtc.minishop.Vo;

import lombok.Data;

import java.util.List;
@Data
public class CategoryVo {
    Integer id;
    String image;
    String name;
    Integer pid;
    List<CategoryVo> sub;
}
