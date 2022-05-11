package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class OrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
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
