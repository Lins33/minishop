package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.entity.Carousel;
import com.wzvtc.minishop.service.CarouselService;

import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarouselController {
    @Autowired
    CarouselService carouselService;

    @GetMapping("/imglist")
    public JSONResult selectAll(){
        List<Carousel> data=carouselService.selectAll();
        return JSONResult.build(1,"",data);
    }


}
