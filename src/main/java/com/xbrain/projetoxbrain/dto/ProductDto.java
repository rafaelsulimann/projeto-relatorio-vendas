package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.xbrain.projetoxbrain.models.enums.CategoryType;

public class ProductDto implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String name;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    @NotBlank
    private Double price;

    @NotBlank
    private CategoryType categoryType;

    public ProductDto(){
    }

    public ProductDto(String name, Double price, CategoryType categoryType) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }    
    
}
