package com.infoshare.fourfan.domain.datatypes;

import java.util.*;
import java.util.stream.Collectors;

public class ProductList{

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

    public void set(int productId, Product product) {
        Optional<Integer> index = productList.stream().filter(p -> p.id == productId).map(p -> productList.indexOf(p)).findFirst();
        if (index.isPresent()) {
            productList.set(index.get(), product);
        } else {
            productList.add(product);
        }
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
