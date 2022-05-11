package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.dto.SellerDto;
import com.xbrain.projetoxbrain.models.SellerModel;

public interface SellerService {

    public List<SellerModel> findAll();
    public SellerModel findById(Long sellerId);
    public SellerModel save(SellerModel sellerModel);
    public SellerModel insert(SellerModel sellerModel);
    public void delete(Long sellerId);
    public SellerModel updateSeller(Long sellerId, SellerModel sellerModel);
    public SellerModel updateImage(Long sellerId, SellerModel sellerModel);
    public SellerModel fromDto(SellerDto sellerDto);
    public boolean existsByFullName(String fullName);
    public boolean existsByCpf(String cpf);
    
}
