package com.wzvtc.minishop.service;

import com.wzvtc.minishop.controller.BuyerVo;
import com.wzvtc.minishop.entity.Buyer;
import com.wzvtc.minishop.repository.BuyerRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Optional;

@Service
public class BuyerService {
    @Autowired
    BuyerRepository buyerRepository;

    public JSONResult login(String username, String password, HttpServletRequest request){
        HttpSession session=request.getSession();
        Optional<Buyer> buyerOptional = buyerRepository.getBuyerByNameAndPassword(username, password);
        if(!buyerOptional.isPresent()){
            return JSONResult.error("用户名或密码错误");
        }
        Buyer buyer=buyerOptional.get();
        BuyerVo buyerVo=new BuyerVo(buyer.getId(),session.getId(),buyer.getName());
        session.setAttribute("buyer",buyerVo);
        session.setMaxInactiveInterval(30*60);
        System.out.println(session.getId());
        return JSONResult.build(1,"登录成功",buyerVo);
    }

    public JSONResult user(HttpServletRequest request){
        HttpSession session = request.getSession();
        BuyerVo buyerVo=(BuyerVo) session.getAttribute("buyer");
        System.out.println(session.getId());
        if (buyerVo!=null){
            return JSONResult.build(1,"登录成功",buyerVo);
        }else {
            return JSONResult.build(2,"未登录",null);
        }
    }

    public JSONResult register(String username,String password,String email,HttpServletRequest request){
        Optional<Buyer> optional = buyerRepository.getBuyerByName(username);
        if(optional.isPresent()){
            return JSONResult.error("用户名已存在");
        }
        Buyer buyer=new Buyer(username,password,email);
        try {
            buyerRepository.save(buyer);
            JSONResult jsonResult=login(username,password,request);
            BuyerVo data = (BuyerVo) jsonResult.getData();
            return JSONResult.build(1,"注册成功",data);
        }catch (Exception e){
            e.printStackTrace();
            return JSONResult.error("注册失败");
        }
    }
}
