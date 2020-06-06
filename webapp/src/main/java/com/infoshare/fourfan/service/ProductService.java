package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.repository.ProductRepository;
import com.infoshare.fourfan.repository.ProductRepositoryBean;

import java.util.logging.Logger;

public class ProductService {

    private static final Logger = Logger.getLogger(ProductService.class.getName());

    public void add (Product product){
        ProductRepository productRepository=new ProductRepositoryBean();
        productRepository.add(product);
    }

public Product findById(Long id){
        ProductRepository productRepository= new ProductRepositoryBean();
        return productRepository.findById(id).orElse(null);

        }
}
