package com.infoshare.fourfan.domain.datatypes;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_products")
public class UserProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    private Integer amount = 1;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "userid")
    private  String useridInt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUseridInt() {
        return useridInt;
    }

    public void setUseridInt(String useridInt) {
        this.useridInt = useridInt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
