package com.infoshare.fourfan.domain.datatypes;

import java.util.Objects;

public class Product {
    Long id;
    String name;
    String brand;
    //Cena reprezentowana w groszach
    Integer price;
    Integer calories;
    Shop shop;
    ProductCategory productCategory;

    public Product(Long id, String name, String brand, Integer price, Integer calories, Shop shop, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.calories = calories;
        this.shop = shop;
        this.productCategory = productCategory;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCalories() {
        return calories;
    }

    public Shop getShop() {
        return shop;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(price, product.price) &&
                Objects.equals(calories, product.calories) &&
                shop == product.shop &&
                productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, price, calories, shop, productCategory);
    }
}
