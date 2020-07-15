package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.service.JsonService;

import javax.ejb.Stateless;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Stateless
public class ProductRepositoryBean implements ProductRepository {

    @Override
    public Optional<Product> findProductById(Integer id) {
        return findAllJson().stream()
                .filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return findAllJson().stream()
                .filter(product -> product.getName().toUpperCase().contains(name.toUpperCase())).findFirst();
    }

    @Override
    public List<Product> findAllJson() {
        return JsonService.readProductsJsonFile().getProductList();
    }

    @Override
    public void saveToJson(Product product) {
        ProductList productList = JsonService.readProductsJsonFile();
        productList.add(product);
        JsonService.saveProductsToJsonFile(productList);
    }

    public void deleteProductFromJson(Product product) {
        ProductList productList = JsonService.readProductsJsonFile();
        productList.delete(product);
        JsonService.saveProductsToJsonFile(productList);
    }

    @Override
    public List<Product> filterByCategory(Integer category) {
        return findAllJson().stream()
                .filter(n -> n.getProductCategory().ordinal() == category)
                .sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> filterByCalories(Integer caloriesMin, Long caloriesMax) {
        return findAllJson().stream()
                .filter(cal -> cal.getCalories() <= caloriesMax && cal.getCalories() >= caloriesMin)
                .sorted(Comparator.comparing(Product::getCalories))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Shop, List<Product>> filterByPriceAndGroupByShop(Integer priceMin, Integer priceMax) {
        return findAllJson().stream()
                .filter(n -> n.getPrice() <= priceMax && n.getPrice() >= priceMin)
                .sorted(comparing(Product::getPrice))
                .collect(Collectors.groupingBy(Product::getShop));
    }
}
