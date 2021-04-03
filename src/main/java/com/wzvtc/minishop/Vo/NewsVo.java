package com.wzvtc.minishop.Vo;

import lombok.Data;

import java.util.Date;

@Data
public class NewsVo {
    Integer id;
    String title;
    Integer click;
    Date add_time;
    String content;
}
