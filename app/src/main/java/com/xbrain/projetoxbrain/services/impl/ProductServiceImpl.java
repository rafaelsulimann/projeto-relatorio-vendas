package com.xbrain.projetoxbrain.services.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.dto.ProductDto;
import com.xbrain.projetoxbrain.models.ProductModel;
import com.xbrain.projetoxbrain.repositories.ProductRepository;
import com.xbrain.projetoxbrain.services.ProductService;
import com.xbrain.projetoxbrain.services.exceptions.ProductNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel findById(Long productId) {
        Optional<ProductModel> obj = productRepository.findById(productId);
        return obj.orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public ProductModel insert(ProductModel productModel) {
        productModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return productModel;
    }

    @Override
    public ProductModel updateProduct(Long productId, ProductModel productModel) {
        ProductModel entity = findById(productId);
        entity.setName(productModel.getName());
        entity.setPrice(productModel.getPrice());
        entity.setCategoryType(productModel.getCategoryType());
        return entity;
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public ProductModel fromDto(ProductDto productDto){
        ProductModel obj = new ProductModel();
        BeanUtils.copyProperties(productDto, obj);
        return obj;
    }

    @Override
    public boolean existsByName(String name){
        return productRepository.existsByName(name);
    }
    
}
