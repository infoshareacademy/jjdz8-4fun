package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductRepository {

    void save(Product product) throws IOException;

    Optional<Product> findByName(String name) throws IOException;

    List<Product> findAll() throws IOException;

    void delete(Product product) throws IOException;

    void saveProductsToJsonFile(ProductList productList);

    ProductList readProductsJsonFile();

}
