package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.service.JsonService;

import javax.ejb.Stateless;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class ProductRepositoryBean implements ProductRepository {

    @Override
    public Optional<Product> findProductById(Long id) {
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
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> filterByCalories(Integer caloriesMin, Integer caloriesMax) {
        return findAllJson().stream()
                .filter(cal -> cal.getCalories() <= caloriesMax && cal.getCalories() >= caloriesMin)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Shop, List<Product>> filterByPriceAndGroupByShop(Integer priceMin, Integer priceMax) {
        return findAllJson().stream()
                .filter(n -> n.getPrice() <= priceMax && n.getPrice() >= priceMin)
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.groupingBy(Product::getShop));
    }
}
