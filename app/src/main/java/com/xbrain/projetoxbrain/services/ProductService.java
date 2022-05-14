package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.dto.ProductDto;
import com.xbrain.projetoxbrain.models.ProductModel;

public interface ProductService {

    public List<ProductModel> findAll();
    public ProductModel findById(Long productId);
    public ProductModel save(ProductModel productModel);
    public ProductModel insert(ProductModel productModel);
    public ProductModel updateProduct(Long productId, ProductModel productModel);
    public void delete(Long productId);
    public ProductModel fromDto(ProductDto productDto);
    public boolean existsByName(String name);
    
}
