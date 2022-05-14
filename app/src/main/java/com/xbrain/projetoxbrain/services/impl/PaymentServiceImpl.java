package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.dto.PaymentDto;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.PaymentModel;
import com.xbrain.projetoxbrain.models.enums.OrderStatus;
import com.xbrain.projetoxbrain.repositories.PaymentRepository;
import com.xbrain.projetoxbrain.services.PaymentService;
import com.xbrain.projetoxbrain.services.exceptions.PaymentNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentModel> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentModel findById(Long paymentId) {
        Optional<PaymentModel> obj = paymentRepository.findById(paymentId);
        return obj.orElseThrow(() -> new PaymentNotFoundException(paymentId));
    }

    @Override
    public List<PaymentModel> findAllPaymentsIntoOrder(Long orderId){
        return paymentRepository.findAllPaymentsIntoOrder(orderId);
    }

    @Override
    public PaymentModel findPaymentIntoOrder(Long orderId, Long paymentId){
        Optional<PaymentModel> obj = paymentRepository.findPaymentoIntoOrder(orderId, paymentId);
        return obj.orElseThrow(() -> new PaymentNotFoundException(paymentId));
    }

    @Override
    public PaymentModel save(PaymentModel paymentModel) {
        return paymentRepository.save(paymentModel);
    }

    @Override
    public void delete(Long paymentId, OrderModel orderModel) {
        orderModel.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public PaymentModel insert(PaymentModel paymentModel, OrderModel orderModel) {
        paymentModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        paymentModel.setMoneyChange((paymentModel.getValor().subtract(orderModel.getTotal())));
        paymentModel.setOrder(orderModel);
        orderModel.setOrderStatus(OrderStatus.PAID);
        return paymentModel;
    }

    @Override
    public PaymentModel fromDto(PaymentDto paymentDto) {
        PaymentModel obj = new PaymentModel();
        BeanUtils.copyProperties(paymentDto, obj);
        return obj;
    }
    
}
