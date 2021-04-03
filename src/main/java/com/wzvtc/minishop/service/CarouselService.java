package com.wzvtc.minishop.service;

import com.wzvtc.minishop.entity.Carousel;
import com.wzvtc.minishop.repository.CarouselRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CarouselService {
    @Autowired
    CarouselRepository carouselRepository;

    //@PostConstruct
//    public void init(){
//        carouselRepository.save(new Carousel(null,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2320258638,1752505344&fm=26&gp=0.jpg","www.baidu.com"));
//    }

    public List<Carousel> selectAll(){
        return carouselRepository.findAll();
    }

}
