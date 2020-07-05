package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;

import javax.ejb.Local;
import java.io.IOException;
import java.util.Optional;

@Local
public interface AdminRepository {

    void saveNewProduct(Product product) throws IOException;

    ProductList showAllProducts() throws IOException;

    Optional<Product> findProductById(Integer id) throws IOException;

    Optional<Product> findProductByName(String name) throws IOException;

    void editProduct(Integer id, Product newProduct) throws IOException;

}
