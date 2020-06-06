package com.infoshare.fourfan.domain.datatypes;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        if (productList.size() == 0) {
            System.out.println("No products saved yet.");
        }
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int size() {
        return productList.size();
    }

    public Product get(Long id) {
        return productList.get(id);
    }

    public void set(Long id, Product product) {
        productList.set(id, product);
    }

    public void remove(Long id) {
        productList.remove(id);
    }

}
