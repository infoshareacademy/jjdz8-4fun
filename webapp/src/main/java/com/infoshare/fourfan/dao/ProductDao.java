package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductDao extends Dao<Product> {

    List<ProductDto> findAllDto();

    Optional<ProductDto> findProductIdDto(Integer id);

    Optional<ProductDto> findProductNameDto(String name);

    Optional<List<ProductDto>> findProductCategoryDto(Integer category);

    Optional<List<ProductDto>> findProductShopDto(Integer shop);

    Optional<List<ProductDto>> findProductCaloriesDto(Integer minCalories, Integer maxCalories);

    Optional<List<ProductDto>> filterByPrice(Integer priceMin, Integer priceMax);

    Optional<ProductDto> findAlreadyExistProductDto(String name,String brand);

}
