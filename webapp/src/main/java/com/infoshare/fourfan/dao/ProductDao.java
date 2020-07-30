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

//    Product findByName(String name);

    List<Product> findAll();

    List<ProductDto> findAllDto();

    Optional<ProductDto> findProductIdDto(Integer id);

    Optional<ProductDto> findProductNameDto(String name);

    Optional<List<ProductDto>> findProductCategoryDto(Integer category);

    Optional<List<ProductDto>> findProductShopDto(Integer shop);

    Optional<List<ProductDto>> findProductCaloriesDto(Integer minCalories, Integer maxCalories);

    Optional<List<ProductDto>> filterByPrice(Integer priceMin, Integer priceMax);

    Optional<ProductDto> findAlreadyExistProductDto(String name,String brand);

}
