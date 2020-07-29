package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.dto.db_ProductCategoryDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface db_ProductCategoryDao extends db_Dao<db_ProductCategory> {

    List<db_ProductCategoryDto> findAllDto();

    Optional<db_ProductCategoryDto> findCategoryIdDto(Integer id);

    Optional<db_ProductCategoryDto> findAlreadyExistProductCategoryDto(String name);

}
