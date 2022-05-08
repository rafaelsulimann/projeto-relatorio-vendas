package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.VendorModel;
import com.xbrain.projetoxbrain.repositories.VendorRepository;
import com.xbrain.projetoxbrain.services.VendorService;
import com.xbrain.projetoxbrain.services.exceptions.VendorNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository sellerRepository;

    @Override
    public List<VendorModel> findAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public VendorModel findSellerById(Long sellerId) {
        Optional<VendorModel> obj = sellerRepository.findById(sellerId);
        return obj.orElseThrow(() -> new VendorNotFoundException(sellerId));
    }

    @Override
    public VendorModel save(VendorModel sellerModel) {
        return sellerRepository.save(sellerModel);
    }

    @Override
    public VendorModel insert(VendorModel sellerModel) {
        sellerModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        sellerModel.setLastUpdateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return sellerModel;
    }

    @Override
    public void delete(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }
    
}
