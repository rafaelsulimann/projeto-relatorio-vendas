package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.models.VendorModel;

public interface VendorService {

    public List<VendorModel> findAllSellers();
    public VendorModel findSellerById(Long sellerId);
    public VendorModel save(VendorModel sellerModel);
    public VendorModel insert(VendorModel sellerModel);
    public void delete(Long sellerId);
    
}
