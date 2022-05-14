package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;
import java.math.BigInteger;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderItemDto implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long productCode;

    @NotNull
    @Min(1)
    private BigInteger quantity = new BigInteger("0");

    public OrderItemDto(){
    }

    public OrderItemDto(Long productCode, BigInteger quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }    
    
}
