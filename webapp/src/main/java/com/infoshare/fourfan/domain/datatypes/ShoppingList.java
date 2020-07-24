package com.infoshare.fourfan.domain.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingList {

    List<Product> shoppingList = new ArrayList<>();

    public List<Product> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Product> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public int size() {
        return shoppingList.size();
    }

    public Product get(int i) {
        return shoppingList.get(i);
    }

    public void set(int productId, Product product) {
        Optional<Integer> index = shoppingList
                .stream()
                .filter(p -> p.id == productId)
                .map(p -> shoppingList.indexOf(p))
                .findFirst();
        if (index.isPresent()) {
            shoppingList.set(index.get(), product);
        } else {
            shoppingList.add(product);
        }
    }

    public void remove(int i) {
        shoppingList.remove(i);
    }

    public void add(Product product) {
        shoppingList.add(product);
    }

    public void delete(Product product) {
        shoppingList.remove(product);
    }

}
