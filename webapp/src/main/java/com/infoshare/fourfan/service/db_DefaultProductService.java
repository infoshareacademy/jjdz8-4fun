package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.domain.datatypes.db_Shop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class db_DefaultProductService {

    @Inject
    private db_ShopDao db_shopDao;

    @Inject
    db_ProductCategoryDao db_productCategoryDao;

    @Inject
    private db_ShopService db_shopService;

    @Inject
    private db_CategoryService db_categoryService;

    public void createDefaultProduct() {

        // 1 testowy produkt
//        db_Product db_product = new db_Product();
//        db_product.setBrand("brand1");
//        db_product.setCalories(1111);
//        db_product.setName("name1");
//        db_product.setPrice(1111);
//
//        db_Shop db_shop = new db_Shop();
//        db_shop.setShop("sklep1");
//        db_product.setDb_shop(db_shop);
//
//        db_ProductCategory db_productCategory = new db_ProductCategory();
//        db_productCategory.setCategory("kategoria1");
//        db_product.setDb_productCategory(db_productCategory);

        // 2 testowy produkt
        if (db_shopService.getShops().size() == 0) {
            db_Shop db_shop2 = new db_Shop();
            db_shop2.setShop("sklep2");
            db_shopDao.save(db_shop2);
        }
        if (db_categoryService.getCategory().size() == 0) {
            db_ProductCategory db_productCategory2 = new db_ProductCategory();
            db_productCategory2.setCategory("kategoria2");
            db_productCategoryDao.save(db_productCategory2);
        }
    }
}
