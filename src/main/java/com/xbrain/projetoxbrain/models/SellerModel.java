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
import com.xbrain.projetoxbrain.models.enums.SellerStatus;
import com.xbrain.projetoxbrain.models.enums.SellerType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "tb_sellers")
public class SellerModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

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
    private SellerStatus sellerStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SellerType sellerType;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime lastUpdateTime;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<OrderModel> orders = new HashSet<>();

    public SellerModel() {
    }

    public SellerModel(Long sellerId, String fullName, String email, String phoneNumber, String imgUrl, SellerStatus sellerStatus, SellerType sellerType, LocalDateTime creationDate,
            LocalDateTime lastUpdateTime) {
        this.sellerId = sellerId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imgUrl = imgUrl;
        this.sellerStatus = sellerStatus;
        this.sellerType = sellerType;
        this.creationDate = creationDate;
        this.lastUpdateTime = lastUpdateTime;
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

    public SellerStatus getSellerStatus() {
        return sellerStatus;
    }

    public void setSellerStatus(SellerStatus sellerStatus) {
        this.sellerStatus = sellerStatus;
    }

    public SellerType getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerType sellerType) {
        this.sellerType = sellerType;
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
        SellerModel other = (SellerModel) obj;
        if (sellerId == null) {
            if (other.sellerId != null)
                return false;
        } else if (!sellerId.equals(other.sellerId))
            return false;
        return true;
    }    
    
}
