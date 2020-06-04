package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.repository.ProductRepository;
import org.json.simple.JSONObject;

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

    public List<Product> findAllJson() throws IOException {
        return productRepository.findAllJson();
    }

    public void saveToJson(ProductList productList) throws IOException {
        productRepository.saveToJson(productList);
    }

    public Product findProductById(Long id) throws IOException {
        return productRepository.findProductById(id).orElse(null);
    }

    public Product findProductByName(String name) throws IOException {
        return productRepository.findProductByName(name).orElse(null);
    }

    public void deleteProductFromJson(Product product) throws IOException {
        productRepository.deleteProductFromJson(product);
    }
}
