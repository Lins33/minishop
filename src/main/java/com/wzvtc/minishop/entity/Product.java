package com.wzvtc.minishop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String image;
    String name;
    Integer price;
    String parameter;
    String details;
    Integer num;

    @ManyToOne
    SubCategory subCategory;


}
