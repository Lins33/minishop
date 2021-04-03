package com.wzvtc.minishop.controller;

import com.wzvtc.minishop.entity.Contact;
import com.wzvtc.minishop.repository.ContactRepository;
import com.wzvtc.minishop.service.ContactService;
import com.wzvtc.minishop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class ContactController {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactService contactService;

    @GetMapping("/list")
    public List<Contact> selectAll(Integer buyerId){
        return contactRepository.findContactByBuyerId(buyerId);
    }

    @PostMapping("/save")
    public JSONResult save(Contact contact){
        return contactService.save(contact);
    }

    @GetMapping("/edit")
    public JSONResult selectById(Integer id){
        return contactService.selectById(id);
    }
}
