package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.entity.Order;
import com.wzvtc.minishop.repository.OrderRepository;
import com.wzvtc.minishop.service.OrderService;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;



    @GetMapping("/list")
        public List<OrderVo> selectAll(Integer buyerId){
        List<Order> orders= orderRepository.findOrderByBuyerId(buyerId);
       return orders.stream().map(order->toOrderVo(order)).collect(Collectors.toList());
    }

    @GetMapping("/detail")
    public OrderVo selectById1(Integer id){
        return orderRepository.findOrderVoById(id);
    }


    @PostMapping("/create")
    public JSONResult save(@RequestParam(value = "address") Integer contactId, @RequestParam(value = "user") Integer buyerId, @RequestParam(value = "note") String remarks, ProductMsg productMsg){
        return orderService.save(contactId,buyerId,remarks,productMsg);
    }

    @PostMapping("/cancel")
    public JSONResult delete(Integer id){
        return orderService.deleteById(id);
    }

    OrderVo toOrderVo(Order order){

        OrderVo vo=new OrderVo();
        vo.setId(order.getId());
        vo.setAmount(order.getAmount());
        vo.setCreateTime(order.getCreateTime());
        vo.setTotal(order.getTotal());
        vo.setState(order.getState());
        vo.setBuyerId(order.getBuyer().getId());
        vo.setProductId(order.getProduct().getId());
        vo.setProductImage(order.getProduct().getImage());
        vo.setProductName(order.getProduct().getName());

        return vo;
    }

}

