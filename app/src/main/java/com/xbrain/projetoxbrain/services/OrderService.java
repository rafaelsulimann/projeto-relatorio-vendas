package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.dto.OrderDto;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.SellerModel;

public interface OrderService {

    public List<OrderModel> findAll();
    public OrderModel findById(Long orderId);
    public OrderModel save(OrderModel orderModel);
    public OrderModel insert(OrderModel orderModel, SellerModel sellerModel);
    public void delete(OrderModel orderModel);
    public OrderModel updateOrder(Long orderId, SellerModel sellerModel, OrderModel orderModel);
    public OrderModel fromDto(OrderDto orderDto);
    
}
