package com.wzvtc.minishop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String area;
    String name;
    String tel;
    String detail;
    Date createTime;
    Date updateTime;

    @ManyToOne
    Buyer buyer;
}
