package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.dto.db_ShopDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class db_ShopService {

    @EJB
    private db_ShopDao db_shopDao;

    public List<db_ShopDto> getShops(){
        return db_shopDao.findAllDto();
    };


    public void saveNewShop(String name)
    {
        db_Shop db_shop = new db_Shop();
        db_shop.setShop(name);
        db_shopDao.save(db_shop);

    }

    @Transactional
    public void editShop(Integer id, String name)
    {
        db_shopDao.findById(id).ifPresent(shop -> {
            shop.setShop(name);
            db_shopDao.update(shop);
        });
    }

    @Transactional
    public void deleteShop(Integer id)
    {
        db_shopDao.findById(id).ifPresent(shop -> db_shopDao.delete(shop));
    }

}
