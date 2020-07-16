package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class db_DefaultProductService {

    @EJB
    private db_ProductDao productdbDao;

    public void createDefaultProduct() {

        // 1 testowy produkt
        db_Product db_product = new db_Product();
        db_product.setBrand("brand1");
        db_product.setCalories(1111);
        db_product.setName("name1");
        db_product.setPrice(1111);

        db_Shop db_shop = new db_Shop();
        db_shop.setShop("sklep1");
        db_product.setDb_shop(db_shop);

        db_ProductCategory db_productCategory = new db_ProductCategory();
        db_productCategory.setCategory("kategoria1");
        db_product.setDb_productCategory(db_productCategory);

        // 2 testowy produkt
        db_Product db_product2 = new db_Product();
        db_product2.setBrand("brand2");
        db_product2.setCalories(2222);
        db_product2.setName("name2");
        db_product2.setPrice(2222);

        db_Shop db_shop2 = new db_Shop();
        db_shop2.setShop("sklep2");
        db_product2.setDb_shop(db_shop2);

        db_ProductCategory db_productCategory2 = new db_ProductCategory();
        db_productCategory2.setCategory("kategoria2");
        db_product2.setDb_productCategory(db_productCategory2);

        productdbDao.save(db_product);
        productdbDao.save(db_product2);
    }
}
