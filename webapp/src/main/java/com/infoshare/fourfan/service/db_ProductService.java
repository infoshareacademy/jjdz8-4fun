package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.dto.db_ProductDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class db_ProductService {

    @EJB
    private db_ProductDao db_productDao;

    @EJB
    private db_ShopDao db_shopDao;

    @EJB
    private db_ProductCategoryDao db_productCategoryDao;


    public List<db_ProductDto> getProducts(){
        return db_productDao.findAllDto();
    };

    @Transactional
    public void saveNewProductDB(String name, String brand, Integer price, Integer calories, Integer shop, Integer category)
    {
        db_Product db_product = new db_Product();
        db_product.setBrand(brand);
        db_product.setCalories(calories);
        db_product.setName(name);
        db_product.setPrice(price);
        db_productDao.save(db_product);

        db_shopDao.findById(shop).ifPresent(s -> {db_product.setDb_shop(s); db_productDao.update(db_product);});
        db_productCategoryDao.findById(category).ifPresent(c -> {db_product.setDb_productCategory(c); db_productDao.update(db_product);});
    }

    @Transactional
    public void deleteProduct(Integer id)
    {
        db_productDao.findById(id).ifPresent(db_product -> db_productDao.delete(db_product));
    }

    @Transactional
    public void editProduct(Integer id, String name, String brand, Integer price, Integer calories, Integer shop, Integer category)
    {
        db_productDao.findById(id).ifPresent(db_product -> {
            db_product.setName(name);
            db_product.setBrand(brand);
            db_product.setPrice(price);
            db_product.setCalories(calories);
            db_productDao.update(db_product);

        db_shopDao.findById(shop).ifPresent(s -> {db_product.setDb_shop(s); db_productDao.update(db_product);});
        db_productCategoryDao.findById(category).ifPresent(c -> {db_product.setDb_productCategory(c); db_productDao.update(db_product);});
        });
    }
}
