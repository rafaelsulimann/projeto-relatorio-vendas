package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.models.OrderItemModel;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.ProductModel;

public interface OrderItemService {

    public List<OrderItemModel> findAllOrderItems();
    public OrderItemModel findOrderItemById(Long orderItemId);
    public OrderItemModel save(OrderItemModel orderItemModel);
    public OrderItemModel insert(OrderItemModel orderItemModel, ProductModel productModel, OrderModel orderModel);
    public void delete(Long orderItemId);
    
}
