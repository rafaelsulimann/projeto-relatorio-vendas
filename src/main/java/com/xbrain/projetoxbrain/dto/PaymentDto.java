package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.xbrain.projetoxbrain.models.enums.PaymentType;

public class PaymentDto implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull
    private PaymentType paymentType;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    @NotNull
    private BigDecimal valor = new BigDecimal("0.0").setScale(2);

    public PaymentDto(){
    }

    public PaymentDto(PaymentType paymentType, BigDecimal valor) {
        this.paymentType = paymentType;
        this.valor = valor;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }    
    
}
