package com.xbrain.projetoxbrain.repositories;

import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.OrderItemModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, Long>{

    @Query(value = "select * from tb_order_item where order_id = :orderId", nativeQuery = true)
    List<OrderItemModel> findAllOrderItemsIntoOrder(@Param("orderId") Long orderId);

    @Query(value = "select * from tb_order_item where order_id = :orderId and order_item_id = :orderItemId ", nativeQuery = true)
    Optional<OrderItemModel> findOrderItemIntoOrder(@Param("orderId") Long orderId, @Param("orderItemId") Long orderItemId);
    
}
