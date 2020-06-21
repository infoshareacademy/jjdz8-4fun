package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductDao extends Dao<Product> {

    List<ProductDto> findAllDto();


}
