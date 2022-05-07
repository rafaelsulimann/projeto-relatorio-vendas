package com.xbrain.projetoxbrain.services.exceptions;

public class OrderNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OrderNotFoundException(Object id){
        super("Order not found. id " + id);
    }
    
}
