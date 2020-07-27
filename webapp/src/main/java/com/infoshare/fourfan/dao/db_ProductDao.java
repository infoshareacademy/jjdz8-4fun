package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.dto.db_ProductDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface db_ProductDao extends db_Dao<db_Product> {

    List<db_ProductDto> findAllDto();

    Optional<db_ProductDto> findProductDto(Integer id);

}
