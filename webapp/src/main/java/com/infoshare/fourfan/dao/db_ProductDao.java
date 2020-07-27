package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.dto.db_ProductDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface db_ProductDao extends db_Dao<db_Product> {

    List<db_ProductDto> findAllDto();

    Optional<db_ProductDto> findProductIdDto(Integer id);

    Optional<db_ProductDto> findProductNameDto(String name);

    Optional<List<db_ProductDto>> findProductCategoryDto(Integer category);

    Optional<List<db_ProductDto>> findProductCaloriesDto(Integer minCalories, Integer maxCalories);

    Optional<List<db_ProductDto>> filterByPrice(Integer priceMin, Integer priceMax);


}
