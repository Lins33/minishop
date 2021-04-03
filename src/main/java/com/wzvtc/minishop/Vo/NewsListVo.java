package com.wzvtc.minishop.Vo;

import lombok.Data;

import java.util.Date;

@Data
public class NewsListVo {
    Integer id;
    String title;
    Date add_time;
    String zhaiyao;
    Integer click;
    String img_url;
}
