package com.xbrain.projetoxbrain.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

public class SellerDto implements Serializable{

    private static final long serialVersionUID = 1L;

    public interface SellerView{
        public static interface RegistrationPost{}
        public static interface SellerPut{}
        public static interface ImagePut{}
    }

    @NotBlank
    @JsonView({SellerView.RegistrationPost.class, SellerView.SellerPut.class})
    private String fullName;

    @Size(min = 11, max = 11)
    @NotBlank
    @JsonView(SellerView.RegistrationPost.class)
    private String cpf;

    @NotBlank
    @Email
    @JsonView({SellerView.RegistrationPost.class, SellerView.SellerPut.class})
    private String email;

    @Size(min = 11, max = 11)
    @JsonView({SellerView.RegistrationPost.class, SellerView.SellerPut.class})
    private String phoneNumber;

    @NotBlank
    @JsonView(SellerView.ImagePut.class)
    private String imgUrl;   

    public SellerDto(){
    }

    public SellerDto(String fullName, String cpf, String email, String phoneNumber, String imgUrl) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imgUrl = imgUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    
}
