package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long orderSellerId;

    public OrderDto(){
    }    

    public OrderDto(Long orderSellerId){
        this.orderSellerId = orderSellerId;
    }

    public Long getOrderSellerId() {
        return orderSellerId;
    }

    public void setOrderSellerId(Long orderSellerId) {
        this.orderSellerId = orderSellerId;
    }
    
}
