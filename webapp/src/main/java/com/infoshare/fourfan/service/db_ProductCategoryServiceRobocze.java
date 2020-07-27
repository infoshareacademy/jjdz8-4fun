package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.dto.db_ProductCategoryDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class db_ProductCategoryServiceRobocze {

    @EJB
    private db_ProductCategoryDao db_productCategoryDao;

    public List<db_ProductCategoryDto> getCategory(){
        return db_productCategoryDao.findAllDto();
    };
}
