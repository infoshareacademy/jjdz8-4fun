package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.dto.db_ShopDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class db_ShopServiceRobocze {

    @EJB
    private db_ShopDao db_shopDao;

    public List<db_ShopDto> getShops(){
        return db_shopDao.findAllDto();
    };
}
