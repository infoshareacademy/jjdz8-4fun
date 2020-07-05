package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.repository.AdminRepository;
import com.infoshare.fourfan.repository.ProductRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;

@RequestScoped
public class AdminService {

    @EJB
    private AdminRepository adminRepository;

    @EJB
    private ProductRepository productRepository;

    public void saveNewProduct(Product product) throws IOException {
        adminRepository.saveNewProduct(product);
    }

    public Product findProductById(Integer id) throws IOException {
        return adminRepository
                .findProductById(id)
                .orElse(null);
    }

    public void editProduct(Integer id, Product newProduct) throws IOException {
        adminRepository.editProduct(id, newProduct);
    }

//    public ProductList showAllProducts() throws IOException {
//        return productRepository.();
//    }

//    public Product findProductByName(String name) throws IOException {
//        return productRepository
//                .findProductByName(name)
//                .orElse(null);
//    }
}
