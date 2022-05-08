package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import com.xbrain.projetoxbrain.models.VendorModel;

public class VendorSalesDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long vendorId;
    private String fullName;
    private Integer totalSales;
    private Double totalSalesValor;
    private Double salesPerDay;

    public VendorSalesDto() {
    }

    public VendorSalesDto(VendorModel vendorModel, Double salesPerDay){
        vendorId = vendorModel.getVendorId();
        fullName = vendorModel.getFullName();
        totalSales = vendorModel.totalSales();
        totalSalesValor = vendorModel.totalSalesValor();
        this.salesPerDay = salesPerDay;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
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
        result = prime * result + ((vendorId == null) ? 0 : vendorId.hashCode());
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
        VendorSalesDto other = (VendorSalesDto) obj;
        if (vendorId == null) {
            if (other.vendorId != null)
                return false;
        } else if (!vendorId.equals(other.vendorId))
            return false;
        return true;
    }    
    
}
