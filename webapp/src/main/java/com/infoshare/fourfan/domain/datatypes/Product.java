package com.infoshare.fourfan.domain.datatypes;

public class Product {

    private Long id;
    private String name;
    private String brand;
    //Cena reprezentowana w groszach
    private Integer price;
    private Integer calories;
    private Shop shop;
    private ProductCategory productCategory;

    public Product(Long id,String name, String brand, Integer price, Integer calories, Shop shop, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.calories = calories;
        this.shop = shop;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
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
}
