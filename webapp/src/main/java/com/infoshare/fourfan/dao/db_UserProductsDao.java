package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_UserProducts;
import com.infoshare.fourfan.dto.db_UserProductsDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface db_UserProductsDao extends db_Dao<db_UserProducts> {

    List<db_UserProductsDto> findAllDto();

    Optional<List<db_UserProductsDto>> findProductsUserIdDto(Integer id);

    Optional<db_UserProductsDto> findOneProductUserIdDto(Integer id);

    void deleteAllUserShoppingList(Integer id);


}
