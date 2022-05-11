package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import com.xbrain.projetoxbrain.models.SellerModel;

public class SellerSalesDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long sellerId;
    private String fullName;
    private Integer totalSales;
    private Double totalSalesValor;
    private Double salesPerDay;

    public SellerSalesDto() {
    }

    public SellerSalesDto(SellerModel sellerModel, Double salesPerDay){
        sellerId = sellerModel.getSellerId();
        fullName = sellerModel.getFullName();
        totalSales = sellerModel.totalSales();
        totalSalesValor = sellerModel.totalSalesValor();
        this.salesPerDay = salesPerDay;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public Double getTotalSalesValor() {
        return totalSalesValor;
    }

    public void setTotalSalesValor(Double totalSalesValor) {
        this.totalSalesValor = totalSalesValor;
    }

    public Double getSalesPerDay() {
        return salesPerDay;
    }

    public void setSalesPerDay(Double salesPerDay) {
        this.salesPerDay = salesPerDay;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sellerId == null) ? 0 : sellerId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SellerSalesDto other = (SellerSalesDto) obj;
        if (sellerId == null) {
            if (other.sellerId != null)
                return false;
        } else if (!sellerId.equals(other.sellerId))
            return false;
        return true;
    }    
    
}
