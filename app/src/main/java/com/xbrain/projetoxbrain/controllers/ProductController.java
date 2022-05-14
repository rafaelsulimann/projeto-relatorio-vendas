package com.xbrain.projetoxbrain.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.xbrain.projetoxbrain.dto.ProductDto;
import com.xbrain.projetoxbrain.models.ProductModel;
import com.xbrain.projetoxbrain.services.ProductService;
import com.xbrain.projetoxbrain.services.exceptions.ExistsByNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAllProducts(){
        List<ProductModel> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductModel> findProductById(@PathVariable Long productId){
        ProductModel obj = productService.findById(productId);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long productId){
        findProductById(productId);
        productService.delete(productId);
        return ResponseEntity.ok().body("Product deleted successfully");
    }

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Validated ProductDto productDto){
        if (productService.existsByName(productDto.getName())){
            throw new ExistsByNameException(productDto.getName());
        }
        ProductModel obj = productService.fromDto(productDto);
        obj = productService.insert(obj);
        obj = productService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(obj.getProductId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductDto productDto){
        ProductModel obj = productService.fromDto(productDto);
        obj = productService.updateProduct(productId, obj);
        obj = productService.save(obj);
        return ResponseEntity.ok().body(obj);
    }
    
}
