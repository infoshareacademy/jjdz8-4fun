package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;

import javax.ejb.Local;
import java.io.IOException;

@Local
public interface AdminRepository {

    void saveNewProduct(Product product) throws IOException;

    ProductList showAllProducts() throws IOException;

    Product findProductById(Integer id) throws IOException;

    void editProduct(Long id, Product product) throws IOException;
}
