package com.wzvtc.minishop.Vo;

import lombok.Data;

import java.util.Date;
@Data
public class productVo {
    Integer id;
    Integer goods_category_id;
    String name;
    String sell_point;
    Integer price;
    Integer num;
    String image;
    Integer status;
    String content;
    String album;
    Date delete_time;
    Date create_time;
    Date update_time;

}
