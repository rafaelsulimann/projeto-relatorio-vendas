package com.xbrain.projetoxbrain.services.exceptions;

public class ExistsByNameException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExistsByNameException(String userName){
        super("Product name is already exists. name: " + userName);
    }
    
}
