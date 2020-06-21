package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProductServiceDb {

    @EJB
    private ProductDao productDao;

    public List<ProductDto> getProducts(){
        return productDao.findAllDto();
    };
}
