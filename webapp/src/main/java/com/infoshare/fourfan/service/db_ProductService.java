package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.db_ProductCategoryDao;
import com.infoshare.fourfan.dao.db_ProductDao;
import com.infoshare.fourfan.dao.db_ShopDao;
import com.infoshare.fourfan.dao.db_UserProductsDao;
import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.domain.datatypes.db_UserProducts;
import com.infoshare.fourfan.dto.db_ProductDto;
import com.infoshare.fourfan.dto.db_UserProductsDto;

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
    private db_UserProductsDao db_userProductsDao;

    @EJB
    private db_ProductCategoryDao db_productCategoryDao;


    public List<db_ProductDto> getProducts(){
        return db_productDao.findAllDto();
    };

    public List<db_UserProductsDto> getUserListProducts(){
        return db_userProductsDao.findAllDto();
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
    public void saveProductToUserList(Integer userId, Integer productId)
    {
        db_UserProducts db_userProducts = new db_UserProducts();
        db_userProducts.setUseridInt(userId);
        db_userProductsDao.save(db_userProducts);

        db_productDao.findById(productId).ifPresent(s -> {db_userProducts.setDb_product(s); db_userProductsDao.update(db_userProducts);});

    }

    @Transactional
    public void editProductFromUserList(Integer id, Integer amount)
    {
        db_userProductsDao.findById(id).ifPresent(db_userProducts -> {
            db_userProducts.setAmount(amount);
            db_userProductsDao.update(db_userProducts);
        });
    }

    @Transactional
    public void deleteProductFromUserList(Integer id)
    {
        db_userProductsDao.findById(id).ifPresent(db_product -> db_userProductsDao.delete(db_product));
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

    public void saveNewShop(String name)
    {
        db_Shop db_shop = new db_Shop();
        db_shop.setShop(name);
        db_shopDao.save(db_shop);

    }

    public void saveNewCategory(String name)
    {
        db_ProductCategory db_productCategory = new db_ProductCategory();
        db_productCategory.setCategory(name);
        db_productCategoryDao.save(db_productCategory);
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

    @Transactional
    public void editCategory(Integer id, String name)
    {
        db_productCategoryDao.findById(id).ifPresent(productCategory -> {
            productCategory.setCategory(name);
        db_productCategoryDao.update(productCategory);
        });
    }

    @Transactional
    public void deleteCategory(Integer id)
    {
        db_productCategoryDao.findById(id).ifPresent(db_productCategory -> db_productCategoryDao.delete(db_productCategory));
    }
}
