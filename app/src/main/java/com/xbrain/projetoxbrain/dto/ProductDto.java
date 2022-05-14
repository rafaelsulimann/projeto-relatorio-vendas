package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.xbrain.projetoxbrain.models.enums.CategoryType;

public class ProductDto implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    @NotNull
    private BigDecimal price = new BigDecimal("0.0").setScale(2);

    @NotNull
    private CategoryType categoryType;

    public ProductDto(){
    }

    public ProductDto(String name, BigDecimal price, CategoryType categoryType) {
        this.name = name;
        this.price = price;
        this.categoryType = categoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }    
    
}
