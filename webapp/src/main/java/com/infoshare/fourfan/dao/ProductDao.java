package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductDao extends Dao<Product> {


    void save(Product product);

    void update(Product product);

    void updateDb(Integer productId, Product product);

    void delete(Product product);

    Optional<Product> findById(Integer id);

    Product findByName(String name);

    List<Product> findAll();

    List<ProductDto> findAllDto();


}
