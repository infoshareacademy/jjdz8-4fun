package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.dto.ShopDto;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface ShopDao extends Dao<Shop> {

    List<ShopDto> findAllDto();

    Optional<ShopDto> findShopIdDto(Integer id);

    Optional<ShopDto> findAlreadyExistShopDto(String name);

}
