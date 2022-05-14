package com.xbrain.projetoxbrain.services.exceptions;

public class PaymentWithoutItems extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PaymentWithoutItems(Object id){
        super("Unable to make a payment without items. order id: " + id);
    }
    
}
