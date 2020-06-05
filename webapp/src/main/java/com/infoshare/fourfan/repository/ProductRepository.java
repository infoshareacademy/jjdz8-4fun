package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductRepository {

    Optional<Product> findProductByName(String name) throws IOException;

    Optional<Product> findProductById(Long id) throws IOException;

    List<Product> findAllJson() throws IOException;

    void saveToJson(Product product) throws IOException;

    void deleteProductFromJson(Product product) throws IOException;



}
