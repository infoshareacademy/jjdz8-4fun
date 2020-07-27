package com.infoshare.fourfan.domain.datatypes;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class db_Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    private String name;

    @Basic
    private String brand;

    @Basic
    private Integer price;

    @Basic
    private Integer calories;

    @Basic
    private Integer amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shop_id")
    private db_Shop db_shop;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private db_ProductCategory db_productCategory;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public db_Shop getDb_shop() {
        return db_shop;
    }

    public void setDb_shop(db_Shop db_shop) {
        this.db_shop = db_shop;
    }

    public db_ProductCategory getDb_productCategory() {
        return db_productCategory;
    }

    public void setDb_productCategory(db_ProductCategory db_productCategory) {
        this.db_productCategory = db_productCategory;
    }
}
