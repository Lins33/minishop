package com.wzvtc.minishop.repository;

import com.wzvtc.minishop.controller.OrderVo;
import com.wzvtc.minishop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
                                                        //int, int, java.lang.String, java.util.Date, int, int, java.lang.String, java.lang.String,int
    @Query("select new com.wzvtc.minishop.controller.OrderVo(o.id,o.total,o.state,o.amount,p.id,p.name,p.image,b.id,o.createTime) " +
            "from Order o,Product p,Buyer b where o.id=?1 and o.product.id=p.id and o.buyer.id=b.id")
    public OrderVo findOrderVoById(Integer id);

    List<Order> findOrderByBuyerId(Integer buyer_id);
}
