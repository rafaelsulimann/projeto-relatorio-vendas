package com.xbrain.projetoxbrain.services.exceptions;

public class ExistsByFullNameException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExistsByFullNameException(String userName){
        super("Seller name is already exists. name: " + userName);
    }
    
}
