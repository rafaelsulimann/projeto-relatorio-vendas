package com.xbrain.projetoxbrain.services.exceptions;

public class PaymentNotEnoughMoneyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PaymentNotEnoughMoneyException(Object amountMissing){
        super("Not enough money to make the purchase. Amount missing " + amountMissing);
    }
}
