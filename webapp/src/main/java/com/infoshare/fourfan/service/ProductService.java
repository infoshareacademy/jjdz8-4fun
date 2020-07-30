package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductCategoryDao;
import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.dao.ShopDao;
import com.infoshare.fourfan.dao.UserProductsDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.UserProducts;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class ProductService {

    @EJB
    private ProductDao productDao;

    @EJB
    private ShopDao shopDao;

    @EJB
    private UserProductsDao userProductsDao;

    @EJB
    private ProductCategoryDao productCategoryDao;


    public List<ProductDto> getProducts(){
        return productDao.findAllDto();
    };

    @Transactional
    public void saveNewProductDB(String name, String brand, Integer price, Integer calories, Integer shop, Integer category)
    {
        Product product = new Product();
        product.setBrand(brand);
        product.setCalories(calories);
        product.setName(name);
        product.setPrice(price);
        productDao.save(product);

        shopDao.findById(shop).ifPresent(s -> {
            product.setShop(s); productDao.update(product);});
        productCategoryDao.findById(category).ifPresent(c -> {
            product.setProductCategory(c); productDao.update(product);});
    }

    @Transactional
    public void saveProductToUserList(Integer userId, Integer productId)
    {
        UserProducts userProducts = new UserProducts();
        userProducts.setUseridInt(userId);
        userProductsDao.save(userProducts);

        productDao.findById(productId).ifPresent(s -> {
            userProducts.setProduct(s); userProductsDao.update(userProducts);});

    }

    @Transactional
    public void editProductFromUserList(Integer id, Integer amount)
    {
        userProductsDao.findById(id).ifPresent(userProducts -> {
            userProducts.setAmount(amount);
            userProductsDao.update(userProducts);
        });
    }

    @Transactional
    public void deleteProductFromUserList(Integer id)
    {
        userProductsDao.findById(id).ifPresent(db_product -> userProductsDao.delete(db_product));
    }

    @Transactional
    public void deleteProduct(Integer id)
    {
        productDao.findById(id).ifPresent(db_product -> productDao.delete(db_product));
    }

    @Transactional
    public void editProduct(Integer id, String name, String brand, Integer price, Integer calories, Integer shop, Integer category)
    {
        productDao.findById(id).ifPresent(db_product -> {
            db_product.setName(name);
            db_product.setBrand(brand);
            db_product.setPrice(price);
            db_product.setCalories(calories);
            productDao.update(db_product);

        shopDao.findById(shop).ifPresent(s -> {db_product.setShop(s); productDao.update(db_product);});
        productCategoryDao.findById(category).ifPresent(c -> {db_product.setProductCategory(c); productDao.update(db_product);});
        });
    }
}
