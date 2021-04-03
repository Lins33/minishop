package com.wzvtc.minishop.service;

import com.wzvtc.minishop.controller.ProductMsg;
import com.wzvtc.minishop.entity.Buyer;
import com.wzvtc.minishop.entity.Contact;
import com.wzvtc.minishop.entity.Order;
import com.wzvtc.minishop.entity.Product;
import com.wzvtc.minishop.repository.BuyerRepository;
import com.wzvtc.minishop.repository.ContactRepository;
import com.wzvtc.minishop.repository.OrderRepository;
import com.wzvtc.minishop.repository.ProductRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    BuyerRepository buyerRepository;

    public List<Order> selectAll(){
        return orderRepository.findAll();
    }


    public JSONResult save(Integer contactId,Integer buyerId, String remarks, ProductMsg productMsg){
        try {

            Optional<Product> productOptional=productRepository.findById(productMsg.getId());
            Optional<Contact> contactOptional=contactRepository.findById(contactId);
            Optional<Buyer> buyerOptional=buyerRepository.findById(buyerId);

            if(!productOptional.isPresent()){
                return JSONResult.error("商品不存在!");
            }
            if(!contactOptional.isPresent()){
                return JSONResult.error("收货地址不存在!");
            }
            if (!buyerOptional.isPresent()){
                return JSONResult.error("用户不存在!");
            }

            Product product=productOptional.get();
            Contact contact=contactOptional.get();
            Buyer buyer=buyerOptional.get();



            Order order=new Order();
            order.setTotal(product.getPrice()*productMsg.getCount());
            order.setState("未支付");
            order.setCreateTime(new Date());
            order.setRemarks(remarks);
            order.setFreight(1000);
            order.setAmount(productMsg.getCount());
            order.setProduct(product);
            order.setContact(contact);
            order.setBuyer(buyer);
            orderRepository.save(order);

            product.setNum(product.getNum()-productMsg.getCount());
            productRepository.save(product);
            return JSONResult.build(1,"创建订单成功","");
        }catch (Exception e){
            e.printStackTrace();
            return JSONResult.error("订单创建失败");
        }
    }

    public JSONResult deleteById(Integer id){
        try{
            Optional<Order> orderOptional = orderRepository.findById(id);
            if(!orderOptional.isPresent()){
                return JSONResult.error("订单不存在");
            }
            Order order=orderOptional.get();
            Product product=orderOptional.get().getProduct();
            product.setNum(product.getNum()+order.getAmount());

            orderRepository.deleteById(id);
            return JSONResult.build(1,"取消成功",order);
        }catch (Exception e){
            e.printStackTrace();
            return JSONResult.error("取消失败");
        }
    }
}
