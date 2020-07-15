package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.repository.AdminRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;

@RequestScoped
public class AdminService {

    @EJB
    private AdminRepository adminRepository;

    public void saveNewProduct(Product product) throws IOException { adminRepository.saveNewProduct(product);}


    public ProductList showAllProducts() throws IOException {
        return adminRepository.showAllProducts();
    }

    public Product findProductById(Integer id) throws IOException {
        return adminRepository.findProductById(id).orElse(null);
    }

    public void editProduct(Integer id, Product newProduct) throws IOException {
        adminRepository.editProduct(id, newProduct);
    }
}
