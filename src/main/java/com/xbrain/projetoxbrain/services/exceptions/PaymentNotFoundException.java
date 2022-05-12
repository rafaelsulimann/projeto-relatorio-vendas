package com.xbrain.projetoxbrain.services.exceptions;

public class PaymentNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PaymentNotFoundException(Object id){
        super("Payment not found. id " + id);
    }
    
}
