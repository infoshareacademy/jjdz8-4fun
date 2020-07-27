package com.infoshare.fourfan.dto;

public class db_ProductDto {

    public Integer id;
    private String name;
    private String brand;
    private Integer price;
    private Integer calories;
    private String shop;
    private String productCategory;
    private Integer amount;


    public db_ProductDto(Integer id, String name, String brand, Integer price, Integer calories, String shop, String productCategory, Integer amount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.calories = calories;
        this.shop = shop;
        this.productCategory = productCategory;
        this.amount = amount;
    }

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

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
