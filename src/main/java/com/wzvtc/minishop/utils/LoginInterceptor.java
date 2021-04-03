package com.wzvtc.minishop.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wzvtc.minishop.controller.BuyerVo;
import com.wzvtc.minishop.entity.Buyer;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BuyerVo buyer=(BuyerVo) request.getSession().getAttribute("buyer");
        System.out.println(request.getSession().getId());
        System.out.println(buyer);
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if(buyer==null){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            try {
                Map<String,Object> map=new HashMap<>();
                map.put("code","2");
                map.put("mag","未登录");
                response.getWriter().println(JSON.toJSON(map));
                return false;
            }catch (Exception e){
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }
        return true;
    }
}