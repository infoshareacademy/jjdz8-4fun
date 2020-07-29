package com.infoshare.fourfan.dto;

public class db_UserProductsDto {

    public Integer id;
    private Integer useridInt;
    private String productName;
    private String productBrand;
    private Integer productPrice;
    private Integer productCalories;
    private String productShop;
    private String productCategory;
    private Integer productAmount;

    public db_UserProductsDto(Integer id, Integer useridInt, String productName, String productBrand, Integer productPrice, Integer productCalories, String productShop, String productCategory, Integer productAmount) {
        this.id = id;
        this.useridInt = useridInt;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productCalories = productCalories;
        this.productShop = productShop;
        this.productCategory = productCategory;
        this.productAmount = productAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUseridInt() {
        return useridInt;
    }

    public void setUseridInt(Integer useridInt) {
        this.useridInt = useridInt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductCalories() {
        return productCalories;
    }

    public void setProductCalories(Integer productCalories) {
        this.productCalories = productCalories;
    }

    public String getProductShop() {
        return productShop;
    }

    public void setProductShop(String productShop) {
        this.productShop = productShop;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}
