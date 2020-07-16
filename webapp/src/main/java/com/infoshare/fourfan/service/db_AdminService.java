package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.domain.datatypes.db_Shop;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@RequestScoped
public class db_AdminService {

    @EJB
    private db_ProductDao productdbDao;

    @EJB
    private db_ShopDao db_shopDao;

    @EJB
    private db_ProductCategoryDao db_productCategoryDao;

    @Transactional
    public void saveNewProductDB(String name, String brand, Integer price, Integer calories, Integer shop, Integer category)
    {
        db_Product db_product = new db_Product();
        db_product.setBrand(brand);
        db_product.setCalories(calories);
        db_product.setName(name);
        db_product.setPrice(price);
        productdbDao.save(db_product);

        db_shopDao.findById(shop).ifPresent(s -> {db_product.setDb_shop(s); productdbDao.update(db_product);});
        db_productCategoryDao.findById(category).ifPresent(c -> {db_product.setDb_productCategory(c); productdbDao.update(db_product);});
//        db_shopDao.findById(shop).ifPresent(s -> {s.addProduct(db_product); db_shopDao.update(s);});
//        db_productCategoryDao.findById(category).ifPresent(db_product::setDb_productCategory);



    }










}
