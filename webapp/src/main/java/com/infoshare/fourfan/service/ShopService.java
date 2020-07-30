package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ShopDao;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.dto.ShopDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ShopService {

    @EJB
    private ShopDao shopDao;

    public List<ShopDto> getShops(){
        return shopDao.findAllDto();
    };


    public void saveNewShop(String name)
    {
        Shop shop = new Shop();
        shop.setShop(name);
        shopDao.save(shop);

    }

    @Transactional
    public void editShop(Integer id, String name)
    {
        shopDao.findById(id).ifPresent(shop -> {
            shop.setShop(name);
            shopDao.update(shop);
        });
    }

    @Transactional
    public void deleteShop(Integer id)
    {
        shopDao.findById(id).ifPresent(shop -> shopDao.delete(shop));
    }

}
