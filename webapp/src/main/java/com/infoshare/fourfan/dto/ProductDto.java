package com.infoshare.fourfan.dto;

import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;

public class ProductDto {
    private Integer id;
    private String name;
    private String brand;
    private Integer price;
    private Integer calories;
    private Shop shop;
    private ProductCategory productCategory;
    private Long created;
    private Long lastModified;


//    public ProductDto(Integer id, String name, String brand, Integer price, Integer calories, Shop shop, ProductCategory productCategory) {
//        this.id = id;
//        this.name = name;
//        this.brand = brand;
//        this.price = price;
//        this.calories = calories;
//        this.shop = shop;
//        this.productCategory = productCategory;
//    }

    //---------------------------- G & S -----------------------------------------


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getCreated() {
        return created;
    }


    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }
}
