package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.dto.SellerDto;
import com.xbrain.projetoxbrain.models.SellerModel;
import com.xbrain.projetoxbrain.models.enums.SellerStatus;
import com.xbrain.projetoxbrain.repositories.SellerRepository;
import com.xbrain.projetoxbrain.services.SellerService;
import com.xbrain.projetoxbrain.services.exceptions.SellerNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<SellerModel> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public SellerModel findById(Long sellerId) {
        Optional<SellerModel> obj = sellerRepository.findById(sellerId);
        return obj.orElseThrow(() -> new SellerNotFoundException(sellerId));
    }

    @Override
    public SellerModel save(SellerModel sellerModel) {
        return sellerRepository.save(sellerModel);
    }

    @Override
    public SellerModel insert(SellerModel sellerModel) {
        sellerModel.setSellerStatus(SellerStatus.ACTIVED);
        sellerModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        sellerModel.setLastUpdateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return sellerModel;
    }

    @Override
    public SellerModel updateSeller(Long sellerId, SellerModel sellerModel){
        SellerModel entity = findById(sellerId);
        entity.setFullName(sellerModel.getFullName());
        entity.setEmail(sellerModel.getEmail());
        entity.setPhoneNumber(sellerModel.getPhoneNumber());
        entity.setLastUpdateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return entity;
    }

    @Override
    public SellerModel updateImage(Long sellerId, SellerModel sellerModel){
        SellerModel entity = findById(sellerId);
        entity.setImgUrl(sellerModel.getImgUrl());
        entity.setLastUpdateTime(LocalDateTime.now(ZoneId.of("UTC")));
        return entity;
    }

    @Override
    public void delete(Long sellerId) {
        sellerRepository.deleteById(sellerId);
    }

    @Override
    public SellerModel fromDto(SellerDto sellerDto){
        SellerModel obj = new SellerModel();
        BeanUtils.copyProperties(sellerDto, obj);
        return obj;
    }

    @Override
    public boolean existsByFullName(String fullName){
        return sellerRepository.existsByFullName(fullName);
    }

    @Override
    public boolean existsByCpf(String cpf){
        return sellerRepository.existsByCpf(cpf);
    }
    
}
