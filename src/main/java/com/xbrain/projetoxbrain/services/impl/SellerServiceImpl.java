package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.SellerModel;
import com.xbrain.projetoxbrain.repositories.SellerRepository;
import com.xbrain.projetoxbrain.services.SellerService;
import com.xbrain.projetoxbrain.services.exceptions.SellerNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<SellerModel> findAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public SellerModel findSellerById(Long sellerId) {
        Optional<SellerModel> obj = sellerRepository.findById(sellerId);
        return obj.orElseThrow(() -> new SellerNotFoundException(sellerId));
    }

    @Override
    public SellerModel save(SellerModel sellerModel) {
        return sellerRepository.save(sellerModel);
    }

    @Override
    public SellerModel insert(SellerModel sellerModel) {
        sellerModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        sellerModel.setLastUpdateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return sellerModel;
    }

    @Override
    public void delete(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }
    
}
