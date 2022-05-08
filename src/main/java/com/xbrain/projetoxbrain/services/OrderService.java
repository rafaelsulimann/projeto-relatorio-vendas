package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.VendorModel;

public interface OrderService {

    public List<OrderModel> findAllOrders();
    public OrderModel findOrderById(Long orderId);
    public OrderModel save(OrderModel orderModel);
    public OrderModel insert(OrderModel orderModel, VendorModel vendorModel);
    public void delete(Long orderId);
    
}
