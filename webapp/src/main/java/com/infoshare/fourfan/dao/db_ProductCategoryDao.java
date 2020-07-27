package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.dto.db_ProductCategoryDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface db_ProductCategoryDao extends db_Dao<db_ProductCategory> {

    List<db_ProductCategoryDto> findAllDto();


}
