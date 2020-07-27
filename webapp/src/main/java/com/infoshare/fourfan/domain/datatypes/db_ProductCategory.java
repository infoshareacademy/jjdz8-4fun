package com.infoshare.fourfan.domain.datatypes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products_categories")
public class db_ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    private String category;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @OneToMany(mappedBy = "db_productCategory")
    private Set<db_Product> products = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
