package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dto.db_ProductDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class db_ProductService {

    @EJB
    private db_ProductDao db_productDao;

    public List<db_ProductDto> getProducts(){
        return db_productDao.findAllDto();
    };
}
