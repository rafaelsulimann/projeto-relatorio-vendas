package com.xbrain.projetoxbrain.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.xbrain.projetoxbrain.dto.OrderItemDto;
import com.xbrain.projetoxbrain.models.OrderItemModel;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.ProductModel;
import com.xbrain.projetoxbrain.models.enums.OrderStatus;
import com.xbrain.projetoxbrain.services.OrderItemService;
import com.xbrain.projetoxbrain.services.OrderService;
import com.xbrain.projetoxbrain.services.ProductService;
import com.xbrain.projetoxbrain.services.exceptions.ExistsPaymentByOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;
    
    @GetMapping(value = "/orders/{orderId}/orderitems")
    public ResponseEntity<List<OrderItemModel>> findAllOrderItemsIntoOrder(@PathVariable Long orderId){
        List<OrderItemModel> list = orderItemService.findAll(orderId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/orders/{orderId}/orderitems/{orderItemId}")
    public ResponseEntity<OrderItemModel> findOrderItemIntoOrder(@PathVariable Long orderId, @PathVariable Long orderItemId){
        orderService.findById(orderId);
        OrderItemModel obj = orderItemService.findOrderItemIntoOrder(orderId, orderItemId);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/orders/{orderId}/orderitems/{orderItemId}")
    public ResponseEntity<Object> deleteOrderItem(@PathVariable Long orderId, @PathVariable Long orderItemId){
        OrderModel order = orderService.findById(orderId);
        OrderItemModel obj = orderItemService.findOrderItemIntoOrder(orderId, orderItemId);
        orderItemService.delete(obj, order);
        return ResponseEntity.ok().body("Order item deleted successfully");
    }
    
    @PostMapping(value = "/orders/{orderId}/orderitems")
    public ResponseEntity<OrderItemModel> saveOrderItemIntoOrder(@PathVariable Long orderId, @RequestBody @Valid OrderItemDto orderItemDto){
        ProductModel product = productService.findById(orderItemDto.getProductCode());
        OrderModel order = orderService.findById(orderId);
        if(!order.getOrderStatus().equals(OrderStatus.WAITING_PAYMENT)){
            throw new ExistsPaymentByOrder(orderId);
        }
        OrderItemModel obj = orderItemService.fromDto(orderItemDto);
        obj = orderItemService.insert(obj, product, order);
        obj = orderItemService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderItemId}").buildAndExpand(obj.getOrderItemId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/orders/{orderId}/orderitems/{orderItemId}")
    public ResponseEntity<OrderItemModel> updateOrderItem(@PathVariable Long orderId, @PathVariable Long orderItemId, @RequestBody @Valid OrderItemDto orderItemDto){
        OrderModel order = orderService.findById(orderId);
        ProductModel product = productService.findById(orderItemDto.getProductCode());
        OrderItemModel obj = orderItemService.fromDto(orderItemDto);
        obj = orderItemService.updateOrderItem(orderItemId, obj, product, order);
        obj = orderItemService.save(obj);
        return ResponseEntity.ok().body(obj);
    }
    
}
