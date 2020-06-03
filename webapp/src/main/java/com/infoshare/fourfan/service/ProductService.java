package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.repository.ProductRepository;
import com.infoshare.fourfan.domain.datatypes.ProductList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequestScoped
public class ProductService {

    @EJB
    private ProductRepository productRepository;

    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    public void save(Product product) throws IOException {
        productRepository.save(product);
    }

    public Optional<Product> findByName(String name) throws IOException {
        return productRepository.findByName(name);
    }

    public List<Product> findAll() throws IOException {
        return productRepository.findAll();
    }

    public void delete(Product product) throws IOException {
        productRepository.delete(product);
    }

    public void saveProductsToJsonFile(ProductList productList) {
        productRepository.saveProductsToJsonFile(productList);
    }

    public ProductList readProductsJsonFile() {
        return productRepository.readProductsJsonFile();
    }
}
