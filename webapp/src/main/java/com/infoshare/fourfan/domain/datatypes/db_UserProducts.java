package com.infoshare.fourfan.domain.datatypes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_products")
public class db_UserProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Basic
    private Integer amount = 1;

    @Column(name = "timestamp")
    private Timestamp timestamp;


//    @OneToMany(mappedBy = "db_shop")
//    private Set<db_Product> products = new HashSet<>();

    //-----
    @Column(name = "userid")
    private  Integer useridInt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private db_Product db_product;
    //-----

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

    public Integer getUseridInt() {
        return useridInt;
    }

    public void setUseridInt(Integer useridInt) {
        this.useridInt = useridInt;
    }

    public db_Product getDb_product() {
        return db_product;
    }

    public void setDb_product(db_Product db_product) {
        this.db_product = db_product;
    }
}
