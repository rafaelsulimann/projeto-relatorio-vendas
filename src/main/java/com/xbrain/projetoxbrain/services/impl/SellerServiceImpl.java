package com.xbrain.projetoxbrain.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.xbrain.projetoxbrain.dto.SellerDto;
import com.xbrain.projetoxbrain.dto.SellerSalesDto;
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

    @Override
    public Set<SellerSalesDto> sellerSales(){
        List<SellerModel> sellerList = findAll();
        Set<SellerSalesDto> sellerSalesList = new HashSet<>();
        for(SellerModel seller : sellerList){
            SellerSalesDto obj = new SellerSalesDto(seller);
            sellerSalesList.add(obj);
        }
        return sellerSalesList;
    }

    @Override
    public Set<SellerSalesDto> sellerSalesWithDate(LocalDateTime minDate, LocalDateTime maxDate){
        List<SellerModel> sellerList = sellerRepository.findByOrdersCreationDateBetween(minDate, maxDate);
        long diff = minDate.until(maxDate, ChronoUnit.DAYS);        
        Set<SellerSalesDto> sellerSalesList = new HashSet<>();
        for(SellerModel seller : sellerList){
            SellerSalesDto obj = new SellerSalesDto(seller);
            BigDecimal salesPerDay = new BigDecimal("0.0").setScale(2);
            salesPerDay = obj.getTotalSales().divide(BigDecimal.valueOf(diff), 2, RoundingMode.UP);
            obj.setSalesPerDay(salesPerDay);            
            sellerSalesList.add(obj);
        }
        return sellerSalesList;
    }

    @Override
    public List<SellerModel> findByOrdersCreationDateBetween(LocalDateTime minDate, LocalDateTime maxDate){
        return sellerRepository.findByOrdersCreationDateBetween(minDate, maxDate);
    }
    
}
