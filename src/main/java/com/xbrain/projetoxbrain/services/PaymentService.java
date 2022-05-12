package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.dto.PaymentDto;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.PaymentModel;

public interface PaymentService {

    public List<PaymentModel> findAll();
    public PaymentModel findById(Long paymentId);
    public List<PaymentModel> findAllPaymentsIntoOrder(Long orderId);
    public PaymentModel findPaymentIntoOrder(Long orderId, Long paymentId);
    public PaymentModel save(PaymentModel paymentModel);
    public void delete(Long paymentId, OrderModel orderModel);
    public PaymentModel insert(PaymentModel paymentModel, OrderModel orderModel);
    public PaymentModel fromDto(PaymentDto paymentDto);

    
}
