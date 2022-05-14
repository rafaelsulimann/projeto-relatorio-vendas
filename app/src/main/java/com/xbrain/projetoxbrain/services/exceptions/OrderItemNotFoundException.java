package com.xbrain.projetoxbrain.services.exceptions;

public class OrderItemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OrderItemNotFoundException(Object id){
        super("Order item not found. id " + id);
    }
    
}
