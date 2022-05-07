package com.xbrain.projetoxbrain.services.exceptions;

public class SellerNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public SellerNotFoundException(Object id){
        super("Seller not found. id " + id);
    }
}
