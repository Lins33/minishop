package com.wzvtc.minishop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer total;
    String state;
    Date createTime;
    String remarks;
    Integer freight;
    Integer amount;

    public Order(Integer id, Integer total, String state, Date createTime, String remarks, Integer freight, Integer amount, Integer productId,
            String productName,
            String productImage,Integer buyerId) {
        this.id = id;
        this.total = total;
        this.state = state;
        this.createTime = createTime;
        this.remarks = remarks;
        this.freight = freight;
        this.amount = amount;
        this.product.setId(productId); ;
        this.product.setName(productName);
        this.product.setImage(productImage);
        this.buyer.setId(buyerId);
    }

    @ManyToOne
    Product product;

    @ManyToOne(fetch=FetchType.EAGER)
    Buyer buyer;

    @ManyToOne
    Contact contact;
}
