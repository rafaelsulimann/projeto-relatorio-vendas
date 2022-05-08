package com.xbrain.projetoxbrain.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xbrain.projetoxbrain.models.enums.VendorStatus;
import com.xbrain.projetoxbrain.models.enums.VendorType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "tb_vendors")
public class VendorModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(length = 20)
    private String phoneNumber;

    @Column
    private String imgUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VendorStatus vendorStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VendorType vendorType;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime lastUpdateTime;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<OrderModel> orders = new HashSet<>();

    public VendorModel() {
    }

    public VendorModel(Long vendorId, String fullName, String email, String phoneNumber, String imgUrl, VendorStatus vendorStatus, VendorType vendorType, LocalDateTime creationDate,
            LocalDateTime lastUpdateTime) {
        this.vendorId = vendorId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imgUrl = imgUrl;
        this.vendorStatus = vendorStatus;
        this.vendorType = vendorType;
        this.creationDate = creationDate;
        this.lastUpdateTime = lastUpdateTime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public VendorStatus getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(VendorStatus vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public VendorType getVendorType() {
        return vendorType;
    }

    public void setVendorType(VendorType vendorType) {
        this.vendorType = vendorType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Double totalSalesValor(){
        double sum = 0.0;
        for(OrderModel order : orders){
            sum += order.getTotal();
        }
        return sum;
    }

    public Integer totalSales(){
        return orders.size();
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
        VendorModel other = (VendorModel) obj;
        if (vendorId == null) {
            if (other.vendorId != null)
                return false;
        } else if (!vendorId.equals(other.vendorId))
            return false;
        return true;
    }    
    
}
