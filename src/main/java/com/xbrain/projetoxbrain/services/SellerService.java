package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.models.SellerModel;

public interface SellerService {

    public List<SellerModel> findAllSellers();
    public SellerModel findSellerById(Long sellerId);
    public SellerModel save(SellerModel sellerModel);
    public SellerModel insert(SellerModel sellerModel);
    public void delete(Long sellerId);
    
}
