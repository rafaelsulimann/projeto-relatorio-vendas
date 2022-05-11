package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xbrain.projetoxbrain.dto.OrderDto;
import com.xbrain.projetoxbrain.models.OrderItemModel;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.SellerModel;
import com.xbrain.projetoxbrain.models.enums.OrderStatus;
import com.xbrain.projetoxbrain.repositories.OrderItemRepository;
import com.xbrain.projetoxbrain.repositories.OrderRepository;
import com.xbrain.projetoxbrain.services.OrderService;
import com.xbrain.projetoxbrain.services.exceptions.OrderNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderModel> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel findById(Long orderId) {
        Optional<OrderModel> obj = orderRepository.findById(orderId);
        return obj.orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public OrderModel save(OrderModel orderModel) {
        return orderRepository.save(orderModel);
    }

    @Override
    public OrderModel insert(OrderModel orderModel, SellerModel sellerModel) {
        orderModel.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        orderModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        orderModel.setSeller(sellerModel);
        orderModel.setOrderSellerId(sellerModel.getSellerId());
        orderModel.setSellerFullName(sellerModel.getFullName());
        return orderModel;
    }

    @Override
    public OrderModel updateOrder(Long orderId, SellerModel sellerModel, OrderModel orderModel){
        OrderModel entity = findById(orderId);
        entity.setOrderSellerId(sellerModel.getSellerId());
        entity.setSellerFullName(sellerModel.getFullName());
        entity.setSeller(sellerModel);
        return entity;
    }

    @Transactional
    @Override
    public void delete(OrderModel orderModel) {
        List<OrderItemModel> orderItemList = orderItemRepository.findAllOrderItemsIntoOrder(orderModel.getOrderId());
        if(!orderItemList.isEmpty()) {
            orderItemRepository.deleteAll(orderItemList);
        }
        orderRepository.delete(orderModel);
    }

    @Override
    public OrderModel fromDto(OrderDto orderDto){
        OrderModel obj = new OrderModel();
        BeanUtils.copyProperties(orderDto, obj);
        return obj;
    }
    
}
