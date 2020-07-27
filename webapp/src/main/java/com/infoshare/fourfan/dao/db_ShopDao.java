package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.dto.db_ShopDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface db_ShopDao extends db_Dao<db_Shop> {

    List<db_ShopDto> findAllDto();


}
