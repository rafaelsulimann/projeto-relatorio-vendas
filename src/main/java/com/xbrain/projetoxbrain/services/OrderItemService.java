package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.dto.OrderItemDto;
import com.xbrain.projetoxbrain.models.OrderItemModel;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.ProductModel;

public interface OrderItemService {

    public List<OrderItemModel> findAll(Long orderId);
    public OrderItemModel findOrderItemIntoOrder(Long orderId, Long orderItemId);
    public OrderItemModel findById(Long orderItemId);
    public OrderItemModel updateOrderItem(Long orderItemId, OrderItemModel orderItemModel, ProductModel productModel, OrderModel orderModel);
    public OrderItemModel save(OrderItemModel orderItemModel);
    public OrderItemModel insert(OrderItemModel orderItemModel, ProductModel productModel, OrderModel orderModel);
    public void delete(OrderItemModel orderItemModel, OrderModel orderModel);
    public OrderItemModel fromDto(OrderItemDto orderItemdto);
    
}
