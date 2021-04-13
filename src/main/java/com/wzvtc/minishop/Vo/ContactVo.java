package com.wzvtc.minishop.Vo;

import lombok.Data;

import java.util.Date;
@Data
public class ContactVo {
    Integer id;
    Integer user_user_id;
    String name;
    String tel;
    String area;
    String detail;
    Date create_time;
    Date update_time;
}
