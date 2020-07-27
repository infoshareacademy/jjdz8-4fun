package com.infoshare.fourfan.domain.datatypes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    private static Integer nextid = new ProductList().size();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    private String name;

    @Basic
    private String brand;

    @Basic
    private Integer price;      //Cena reprezentowana w groszach

    @Basic
    private Integer calories;

    @Basic
    private Shop shop;

    @Column(name = "product_category")
    private ProductCategory productCategory;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    private Integer amount;

    public Product(Integer id, String name, String brand, Integer price, Integer calories, Shop shop, ProductCategory productCategory, Integer amount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.calories = calories;
        this.shop = shop;
        this.productCategory = productCategory;
        this.amount = amount;
    }

    public Product() {

    }

    public Product(String nameParam, String brandParam, Integer priceParam, Integer calParam, Shop shopParam, ProductCategory catParam, Integer amountParam) {
    }

    public static Integer getNextid() {
        return nextid;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNextId() {
        id = nextid;
        nextid++;
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
