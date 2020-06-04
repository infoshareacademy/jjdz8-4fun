package com.infoshare.fourfan.domain.datatypes;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int size() {
        return productList.size();
    }

    public Product get(int i) {
        return productList.get(i);
    }

    public void set(int i, Product product) {
        productList.set(i, product);
    }

    public void remove(int i) {
        productList.remove(i);
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void delete(Product product) {
        productList.remove(product);
    }

}
