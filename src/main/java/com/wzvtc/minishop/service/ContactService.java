package com.wzvtc.minishop.service;

import com.wzvtc.minishop.entity.Carousel;
import com.wzvtc.minishop.entity.Contact;
import com.wzvtc.minishop.repository.ContactRepository;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;


    public JSONResult save(Contact contact){
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
