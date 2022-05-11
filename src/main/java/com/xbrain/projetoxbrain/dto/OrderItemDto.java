package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class OrderItemDto implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank
    private Long productCode;

    @NotBlank
    @Min(1)
    private Integer quantity;

    public OrderItemDto(){
    }

    public OrderItemDto(Long productCode, Integer quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }    
    
}
