package com.xbrain.projetoxbrain.repositories;

import com.xbrain.projetoxbrain.models.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    
}
