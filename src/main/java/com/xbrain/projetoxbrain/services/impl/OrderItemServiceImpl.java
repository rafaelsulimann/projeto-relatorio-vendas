package com.xbrain.projetoxbrain.services.impl;

import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.dto.OrderItemDto;
import com.xbrain.projetoxbrain.models.OrderItemModel;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.ProductModel;
import com.xbrain.projetoxbrain.repositories.OrderItemRepository;
import com.xbrain.projetoxbrain.services.OrderItemService;
import com.xbrain.projetoxbrain.services.exceptions.OrderItemNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemModel> findAll(Long orderId) {
        return orderItemRepository.findAllOrderItemsIntoOrder(orderId);
    }

    @Override
    public OrderItemModel findOrderItemIntoOrder(Long orderId, Long orderItemId) {
        Optional<OrderItemModel> orderItemModel = orderItemRepository.findOrderItemIntoOrder(orderId, orderItemId);
        return orderItemModel.orElseThrow(() -> new OrderItemNotFoundException(orderItemId));
    }

    @Override
    public OrderItemModel findById(Long orderItemId){
        Optional<OrderItemModel> orderItemModel = orderItemRepository.findById(orderItemId);
        return orderItemModel.orElseThrow(() -> new OrderItemNotFoundException(orderItemId));
    }

    @Override
    public OrderItemModel save(OrderItemModel orderItemModel) {
        return orderItemRepository.save(orderItemModel);
    }

    @Override
    public OrderItemModel insert(OrderItemModel orderItemModel, ProductModel productModel, OrderModel orderModel) {
        orderItemModel.setProductCode(productModel.getProductId());
        orderItemModel.setProductName(productModel.getName());
        orderItemModel.setProductPrice(productModel.getPrice());
        orderItemModel.setOrder(orderModel);
        orderItemModel.setProduct(productModel);
        orderModel.setTotal((orderModel.getTotal() + orderItemModel.getSubTotal()));
        return orderItemModel;
    }

    @Override
    public void delete(OrderItemModel orderItemModel, OrderModel orderModel) {
        orderModel.setTotal((orderModel.getTotal() - orderItemModel.getSubTotal()));
        orderItemRepository.delete(orderItemModel);
    }

    @Override
    public OrderItemModel updateOrderItem(Long orderItemId, OrderItemModel orderItemModel, ProductModel productModel, OrderModel orderModel){
        OrderItemModel entity = findById(orderItemId);
        orderModel.setTotal((orderModel.getTotal() - entity.getSubTotal()));
        entity.setProductCode(productModel.getProductId());
        entity.setProductName(productModel.getName());
        entity.setProductPrice(productModel.getPrice());
        entity.setProduct(productModel);
        entity.setQuantity(orderItemModel.getQuantity());
        orderModel.setTotal((orderModel.getTotal() + entity.getSubTotal()));
        return entity;
    }

    @Override
    public OrderItemModel fromDto(OrderItemDto orderItemDto){
        OrderItemModel obj = new OrderItemModel();
        BeanUtils.copyProperties(orderItemDto, obj);
        return obj;
    }
    
}
