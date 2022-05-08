package com.xbrain.projetoxbrain.services.impl;

import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.OrderItemModel;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.ProductModel;
import com.xbrain.projetoxbrain.repositories.OrderItemRepository;
import com.xbrain.projetoxbrain.services.OrderItemService;
import com.xbrain.projetoxbrain.services.exceptions.OrderItemNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemModel> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItemModel findOrderItemById(Long orderItemId) {
        Optional<OrderItemModel> orderItemModel = orderItemRepository.findById(orderItemId);
        return orderItemModel.orElseThrow(() -> new OrderItemNotFoundException(orderItemId));
    }

    @Override
    public OrderItemModel save(OrderItemModel orderItemModel) {
        return orderItemRepository.save(orderItemModel);
    }

    @Override
    public OrderItemModel insert(OrderItemModel orderItemModel, ProductModel productModel, OrderModel orderModel) {
        orderItemModel.setOrder(orderModel);
        orderItemModel.setProduct(productModel);
        return orderItemModel;
    }

    @Override
    public void delete(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
    
}
