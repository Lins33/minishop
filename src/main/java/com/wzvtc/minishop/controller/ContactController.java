package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.Vo.ContactVo;
import com.wzvtc.minishop.entity.Contact;
import com.wzvtc.minishop.repository.ContactRepository;
import com.wzvtc.minishop.service.ContactService;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
public class ContactController {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactService contactService;

    @GetMapping()
    public JSONResult selectAll(HttpServletRequest request){

        List<Contact> contact=contactService.list(request);
        List<ContactVo> contactVos=contact.stream().map(this::toContactVo).collect(Collectors.toList());
        return JSONResult.build(1,"",contactVos);
    }

    @PostMapping("/save")
    public JSONResult save(@RequestBody Contact contact,HttpServletRequest request){
        return contactService.save(contact,request);
    }

    @GetMapping("/edit")
    public JSONResult selectById(Integer id){
        return contactService.selectById(id);
    }

    @PostMapping("/del")
    public JSONResult deleteById(@RequestBody Map<String,Integer> param){
        try {
            Integer id=param.get("id");
            System.out.println(id);
            contactService.deleteById(id);
            return JSONResult.build(1,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return JSONResult.error("删除失败");
        }
    }

    ContactVo toContactVo(Contact contact){
        ContactVo vo=new ContactVo();
        vo.setArea(contact.getArea());
        vo.setCreate_time(contact.getCreateTime());
        vo.setUpdate_time(contact.getUpdateTime());
        vo.setDetail(contact.getDetail());
        vo.setId(contact.getId());
        vo.setName(contact.getName());
        vo.setTel(contact.getTel());
        vo.setUser_user_id(contact.getBuyer().getId());

        return vo;
    }

}
