package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.VendorModel;
import com.xbrain.projetoxbrain.models.enums.OrderStatus;
import com.xbrain.projetoxbrain.repositories.OrderRepository;
import com.xbrain.projetoxbrain.services.OrderService;
import com.xbrain.projetoxbrain.services.exceptions.OrderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderModel> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel findOrderById(Long orderId) {
        Optional<OrderModel> obj = orderRepository.findById(orderId);
        return obj.orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public OrderModel save(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    }

    @Override
    public OrderModel insert(OrderModel orderModel, VendorModel vendorModel) {
        orderModel.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        orderModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        orderModel.setVendor(vendorModel);
        return orderModel;
    }

    @Override
    public void delete(Long orderId) {
        orderRepository.deleteById(orderId);
    }
    
}
