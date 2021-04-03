package com.wzvtc.minishop.service;

import com.wzvtc.minishop.entity.News;
import com.wzvtc.minishop.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsRepository;

    public List<News> selectAll(){
        return newsRepository.findAll();
    }

    public News selectById(Integer id){
        News news=newsRepository.findById(id).get();
        news.setHits(news.getHits()+1);
        return newsRepository.save(news);
    }

    //@PostConstruct
//    public void init(){
//        newsRepository.save(new News(null,"yhycs","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2320258638,1752505344&fm=26&gp=0.jpg","contentcontentcontentcontentcontent",10,new Date(System.currentTimeMillis())));
//    }
}
