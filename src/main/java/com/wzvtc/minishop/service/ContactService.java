package com.wzvtc.minishop.service;

import com.wzvtc.minishop.controller.BuyerVo;
import com.wzvtc.minishop.entity.Buyer;
import com.wzvtc.minishop.entity.Carousel;
import com.wzvtc.minishop.entity.Contact;
import com.wzvtc.minishop.repository.BuyerRepository;
import com.wzvtc.minishop.repository.ContactRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    BuyerRepository buyerRepository;
    public List<Contact> list(HttpServletRequest request){
        BuyerVo buyerVo=(BuyerVo) request.getSession().getAttribute("buyer");
        List<Contact> contacts=contactRepository.findContactByBuyerId(buyerVo.getId());
        return contacts;
    }

    public JSONResult save(Contact contact,HttpServletRequest request){

        if(contact.getId()!=null){
            contact.setUpdateTime(new Date());
        }else {
            contact.setCreateTime(new Date());
        }
        Buyer buyer=buyerRepository.findById(((BuyerVo)request.getSession().getAttribute("buyer")).getId()).get();
        contact.setBuyer(buyer);
        return JSONResult.build(1,"添加成功",contactRepository.save(contact));
    }

    public JSONResult selectById(Integer id){
        Optional<Contact> data = contactRepository.findById(id);
        return data.map(contact -> JSONResult.build(1, "", contact)).orElseGet(() -> JSONResult.error("订单不存在"));
    }

    public JSONResult deleteById(Integer id){
        try {
            contactRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return JSONResult.error("删除失败");
        }
        return JSONResult.build(1,"删除成功","");
    }

}
