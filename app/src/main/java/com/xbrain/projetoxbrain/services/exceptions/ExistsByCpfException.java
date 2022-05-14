package com.xbrain.projetoxbrain.services.exceptions;

public class ExistsByCpfException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExistsByCpfException(String cpf){
        super("Seller cpf is already exists. cpf: " + cpf);
    }
    
}
