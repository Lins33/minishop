package com.wzvtc.minishop.controller;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrderVo {

    Integer id;

    Integer total;
    String state;
    Date createTime;
    Integer amount;

    Integer productId;
    String productName;
    String productImage;


    Integer buyerId;
    public OrderVo(Integer id,Integer total,String state,Integer amount,Integer productId,String productName,String productImage,Integer buyerId,Date createTime){
        this.id=id;
        this.total=total;
        this.state=state;
        this.createTime=createTime;
        this.amount=amount;
        this.productId=productId;
        this.productName=productName;
        this.productImage=productImage;
        this.buyerId=buyerId;
    }
}