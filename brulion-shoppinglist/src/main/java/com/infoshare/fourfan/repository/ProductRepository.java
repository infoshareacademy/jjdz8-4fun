package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void add(Product product);

    void delete(Product product);

    boolean contains(Product product);

    Optional<Product> findById(Long id);

    List<Product> findByName(String name);

    List<Product> findByBrand(String brand);

    List<Product> findByPrice(Integer price);

    List<Product> findByCalories(Integer calories);

    List<Product> findByShop(Shop shop);

    List<Product> findByProductCategory(ProductCategory productCategory);

    List<Product>findAllProducts();

    List<Product> findAllProductsForShop(Shop shop);

    List<Product> findAllProductsForName(String name);

    List<Product> findAllProductsForProductCategory(ProductCategory productCategory);

    List<Product> findAllProductsForPrice(Integer price);

    List<Product> findAllProductsForCalories(Integer calories);

    void updateProductName(Product product);

    void updateProductPrice(Product product);

    void updateProductCalories(Product product);

    void updateProductShop(Product product);

    void updateProductCategory(Product product);


}
