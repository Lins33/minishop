package com.wzvtc.minishop.controller;

import com.alibaba.fastjson.JSON;
import com.wzvtc.minishop.Vo.NewsListVo;
import com.wzvtc.minishop.Vo.NewsVo;
import com.wzvtc.minishop.entity.News;
import com.wzvtc.minishop.service.NewsService;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;


    @GetMapping("/list")
    public String selectAll(){
        List<News> lists =newsService.selectAll();
        List<NewsListVo> listVos=lists.stream().map(news ->toNewsVo(news)).collect(Collectors.toList());

        Map<String,Object> map=new HashMap<>();
        map.put("status",0);
        map.put("message",listVos);
        return JSON.toJSONString(map);
    }
    @GetMapping("/show")
    public String selectById(Integer id){
        News news = newsService.selectById(id);
        NewsVo newsVo =new NewsVo();
        newsVo.setAdd_time(news.getCreateTime());
        newsVo.setClick(news.getHits());
        newsVo.setContent(news.getContent());
        newsVo.setId(news.getId());
        newsVo.setTitle(news.getTitle());
        Map<String,Object> map=new HashMap<>();
        map.put("status",0);
        List<NewsVo> list=new ArrayList<>();
        list.add(newsVo);
        map.put("message",list);
        return JSON.toJSONString(map);
    }

    NewsListVo toNewsVo(News news){
        NewsListVo vo=new NewsListVo();
        vo.setAdd_time(news.getCreateTime());
        vo.setClick(news.getHits());
        vo.setId(news.getId());
        vo.setImg_url(news.getImage());
        vo.setTitle(news.getTitle());
        vo.setZhaiyao(news.getZaiyao());
        return vo;
    }
}
