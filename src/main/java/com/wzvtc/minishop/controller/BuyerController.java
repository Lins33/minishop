package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.service.BuyerService;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BuyerController {
    @Autowired
    BuyerService buyerService;


    @PostMapping("/login")
    public JSONResult login(@RequestBody User user, HttpServletRequest request){
        return buyerService.login(user.getUsername(),user.getPassword(),request);
    }

    @GetMapping("/user")
    public JSONResult user(HttpServletRequest request){
        return buyerService.user(request);
    }

    @PostMapping("/register")
    public JSONResult register(@RequestBody User user,HttpServletRequest request){
        return buyerService.register(user.getUsername(),user.getPassword(),user.getEmail(),request);
    }
}
