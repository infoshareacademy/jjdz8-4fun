package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.Users;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.storage.ProductsJsonStorage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.infoshare.fourfan.domain.datatypes.ProductList.getProductList;

@RequestScoped
public class ProductRepositoryBean implements ProductRepository{

    private final ProductList productList = JsonReader.create(new ProductList(), FileNames.USERS_JSON);

    @Inject
    private ProductsJsonStorage productsJsonStorage;

    @Override
    public void add(Product product) {
        getProductList().add(product);
    }

    //TODO consider form of method baring in mind WebInfPathResolver
    @Override
    public void delete(Product product) {
    }

    @Override
    public boolean contains(Product product) {
        if{(product.isEmpty()) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productsJsonStorage.load().getProductList()
                .stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst();
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productsJsonStorage.load()
                .getProductList()
                .stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return this.productsJsonStorage.load()
                .getProductList()
                .stream()
                .filter(product -> product.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByPrice(Integer price) {
        return this.productsJsonStorage.load()
                .getProductList()
                .stream()
                .filter(product -> product.getPrice().equals(price))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByCalories(Integer calories) {
        return null;
    }

    @Override
    public List<Product> findByShop(Shop shop) {
        return null;
    }

    @Override
    public List<Product> findByProductCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return getProductList();
    }

    @Override
    public List<Product> findAllProductsForShop(Shop shop) {
        return null;
    }

    @Override
    public List<Product> findAllProductsForName(String name) {
        return null;
    }

    @Override
    public List<Product> findAllProductsForProductCategory(ProductCategory productCategory) {
        return null;
    }

    @Override
    public List<Product> findAllProductsForPrice(Integer price) {
        return null;
    }

    @Override
    public List<Product> findAllProductsForCalories(Integer calories) {
        return null;
    }

    @Override
    public void updateProductName(Product product) {

    }

    @Override
    public void updateProductPrice(Product product) {

    }

    @Override
    public void updateProductCalories(Product product) {

    }

    @Override
    public void updateProductShop(Product product) {

    }

    @Override
    public void updateProductCategory(Product product) {

    }


}
