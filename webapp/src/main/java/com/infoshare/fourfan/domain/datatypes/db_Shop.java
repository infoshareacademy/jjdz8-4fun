package com.infoshare.fourfan.domain.datatypes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shops")
public class db_Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    private String shop;

    @Column(name = "timestamp")
    private Timestamp timestamp;


    @OneToMany(mappedBy = "db_shop")
    private Set<db_Product> products = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Set<db_Product> getProducts() {
        return products;
    }

    public void setProducts(Set<db_Product> products) {
        this.products = products;
    }

    public void addProduct(db_Product db_product) {
        this.products.add(db_product);
    }


}
