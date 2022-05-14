package com.xbrain.projetoxbrain.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.xbrain.projetoxbrain.dto.PaymentDto;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.PaymentModel;
import com.xbrain.projetoxbrain.models.enums.OrderStatus;
import com.xbrain.projetoxbrain.services.OrderService;
import com.xbrain.projetoxbrain.services.PaymentService;
import com.xbrain.projetoxbrain.services.exceptions.ExistsPaymentByOrder;
import com.xbrain.projetoxbrain.services.exceptions.PaymentNotEnoughMoneyException;
import com.xbrain.projetoxbrain.services.exceptions.PaymentWithoutItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders/{orderId}/payment")
    public ResponseEntity<List<PaymentModel>> findAllPaymentsIntoOrder(@PathVariable Long orderId){
        orderService.findById(orderId);
        List<PaymentModel> list = paymentService.findAllPaymentsIntoOrder(orderId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/orders/{orderId}/payment/{paymentId}")
    public ResponseEntity<PaymentModel> findPaymentIntoOrder(@PathVariable Long orderId, @PathVariable Long paymentId){
        orderService.findById(orderId);
        PaymentModel obj = paymentService.findPaymentIntoOrder(orderId, paymentId);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/orders/{orderId}/payment/{paymentId}")
    public ResponseEntity<Object> deletePayment(@PathVariable Long orderId, @PathVariable Long paymentId){
        OrderModel order = orderService.findById(orderId);
        findPaymentIntoOrder(orderId, paymentId);
        paymentService.delete(paymentId, order);
        return ResponseEntity.ok().body("Payment deleted successfully");
    }
    
    @PostMapping(value = "/orders/{orderId}/payment")
    public ResponseEntity<PaymentModel> savePayment(@PathVariable Long orderId, @RequestBody @Valid PaymentDto paymentDto){
        OrderModel order = orderService.findById(orderId);
        if(!order.getOrderStatus().equals(OrderStatus.WAITING_PAYMENT)){
            throw new ExistsPaymentByOrder(orderId);
        }
        if(order.getItems().size() == 0){
            throw new PaymentWithoutItems(orderId);
        }
        if(order.getTotal().compareTo(paymentDto.getValor()) > 0){
            throw new PaymentNotEnoughMoneyException((order.getTotal().subtract(paymentDto.getValor())));
        }        
        PaymentModel obj = paymentService.fromDto(paymentDto);
        obj = paymentService.insert(obj, order);
        obj = paymentService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{paymentId}").buildAndExpand(obj.getPaymentId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
}
