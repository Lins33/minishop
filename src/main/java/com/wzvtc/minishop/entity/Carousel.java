package com.wzvtc.minishop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Carousel {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String img;
    public Carousel() {
    }
}
