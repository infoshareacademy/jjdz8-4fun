package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.UserProducts;
import com.infoshare.fourfan.dto.UserProductsDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UserProductsDao extends Dao<UserProducts> {

    List<UserProductsDto> findAllDto();

    Optional<List<UserProductsDto>> findProductsUserIdDto(String id);

    Optional<UserProductsDto> findOneProductUserIdDto(Integer id);

    Optional<List<UserProductsDto>>findUserProductIdProductDto(Integer id);

    Optional<UserProductsDto> findUserProductNameDto(String name);

    void deleteAllUserShoppingList(String id);

}
