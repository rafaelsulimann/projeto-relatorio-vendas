package com.xbrain.projetoxbrain.repositories;

import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.PaymentModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Long>{

    @Query(value = "select * from tb_payments where order_id = :orderId", nativeQuery = true)
    List<PaymentModel> findAllPaymentsIntoOrder(@Param("orderId") Long orderId);

    @Query(value = "select * from tn_payments where order_id = :orderId and payment_id = :paymentId ", nativeQuery = true)
    Optional<PaymentModel> findPaymentoIntoOrder(@Param("orderId") Long orderId, @Param("paymentId") Long paymentId);
    
}
