package com.xbrain.projetoxbrain.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.xbrain.projetoxbrain.models.SellerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerModel, Long>{

    //@Query(value = "select * from tb_order_item where order_id = :orderId", nativeQuery = true)
    //List<OrderItemModel> findAllOrderItemsIntoOrder(@Param("orderId") Long orderId);

    List<SellerModel> findByOrdersCreationDateBetween(LocalDateTime minDate, LocalDateTime maxDate);
    boolean existsByFullName(String fullName);
    boolean existsByCpf(String cpf);
    
}
