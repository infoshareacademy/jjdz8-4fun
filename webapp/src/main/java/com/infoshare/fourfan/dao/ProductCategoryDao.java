package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.dto.ProductCategoryDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductCategoryDao extends Dao<ProductCategory> {

    List<ProductCategoryDto> findAllDto();

    Optional<ProductCategoryDto> findCategoryIdDto(Integer id);

    Optional<ProductCategoryDto> findAlreadyExistProductCategoryDto(String name);

}
