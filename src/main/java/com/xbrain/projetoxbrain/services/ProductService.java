package com.xbrain.projetoxbrain.services;

import java.util.List;

import com.xbrain.projetoxbrain.models.ProductModel;

public interface ProductService {

    public List<ProductModel> findAllProducts();
    public ProductModel findProductById(Long productId);
    public ProductModel save(ProductModel productModel);
    public void delete(Long productId);
    
}
