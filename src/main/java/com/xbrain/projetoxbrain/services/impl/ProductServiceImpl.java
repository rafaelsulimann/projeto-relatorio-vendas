package com.xbrain.projetoxbrain.services.impl;

import java.util.List;
import java.util.Optional;

import com.xbrain.projetoxbrain.models.ProductModel;
import com.xbrain.projetoxbrain.repositories.ProductRepository;
import com.xbrain.projetoxbrain.services.ProductService;
import com.xbrain.projetoxbrain.services.exceptions.ProductNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel findProductById(Long productId) {
        Optional<ProductModel> obj = productRepository.findById(productId);
        return obj.orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }
    
}
