package com.example.buysell.services;

import com.example.buysell.models.Products;
import com.example.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService     {

    private final ProductRepository productRepository;
    public List<Products> listProducts(String title){
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(Products product){

        log.info("Saving new {}",product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id){

        productRepository.deleteById(id);
    }

    public Products getProductByID(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
