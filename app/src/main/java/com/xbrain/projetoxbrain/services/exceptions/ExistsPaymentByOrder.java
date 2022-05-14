package com.xbrain.projetoxbrain.services.exceptions;

public class ExistsPaymentByOrder extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExistsPaymentByOrder(Long orderId){
        super("Payment is already exists in this order. order id: " + orderId);
    }
    
}
