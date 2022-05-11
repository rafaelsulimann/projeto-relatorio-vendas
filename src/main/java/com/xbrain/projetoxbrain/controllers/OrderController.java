package com.xbrain.projetoxbrain.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.xbrain.projetoxbrain.dto.OrderDto;
import com.xbrain.projetoxbrain.models.OrderModel;
import com.xbrain.projetoxbrain.models.SellerModel;
import com.xbrain.projetoxbrain.services.OrderService;
import com.xbrain.projetoxbrain.services.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> findAllOrders(){
        List<OrderModel> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderModel> findOrderById(@PathVariable Long orderId){
        OrderModel obj = orderService.findById(orderId);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long orderId){
        ResponseEntity<OrderModel> obj = findOrderById(orderId);
        orderService.delete(obj.getBody());
        return ResponseEntity.ok().body("Order deleted successfully");
    }

    @PostMapping
    public ResponseEntity<OrderModel> saveOrder(@RequestBody @Valid OrderDto orderDto){
        SellerModel seller = sellerService.findById(orderDto.getOrderSellerId());
        OrderModel obj = orderService.fromDto(orderDto);
        obj = orderService.insert(obj, seller);
        obj = orderService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderId}").buildAndExpand(obj.getOrderId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{orderId}")
    public ResponseEntity<OrderModel> updateOrder(@PathVariable Long orderId, @RequestBody @Valid OrderDto orderDto){
        SellerModel seller = sellerService.findById(orderDto.getOrderSellerId());
        OrderModel obj = orderService.fromDto(orderDto);
        obj = orderService.updateOrder(orderId, seller, obj);
        obj = orderService.save(obj);
        return ResponseEntity.ok().body(obj);
    }
    
}
