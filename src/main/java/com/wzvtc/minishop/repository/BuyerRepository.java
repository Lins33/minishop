package com.wzvtc.minishop.repository;

import com.wzvtc.minishop.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Integer> {
    Optional<Buyer> getBuyerByNameAndPassword(String name, String password);

    Optional<Buyer> getBuyerByName(String name);
}
