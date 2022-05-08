package com.xbrain.projetoxbrain.services.exceptions;

public class VendorNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public VendorNotFoundException(Object id){
        super("Seller not found. id " + id);
    }
}
