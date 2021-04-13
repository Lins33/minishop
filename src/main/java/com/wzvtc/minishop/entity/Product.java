package com.wzvtc.minishop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    String sell_point;
    Integer price;
    Integer num;
    String image;
    Integer status;
    String content;
    String album;
    Date delete_time;
    Date create_time;
    Date update_time;

    @ManyToOne
    SubCategory subCategory;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "product")
    Set<Album> albums;
}
