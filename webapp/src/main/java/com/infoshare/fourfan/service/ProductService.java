package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.repository.ProductRepository;
import com.infoshare.fourfan.storage.ProductDb;
import org.json.simple.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class ProductService {


    public static ProductList productList = ProductDb.getRepository();

    @EJB
    private ProductRepository productRepository;

    public List<Product> findAllJson() throws IOException {
        return productRepository.findAllJson();
    }

    public void saveToJson(ProductList productList) throws IOException {
        productRepository.saveToJson(productList);
    }

    public Product findProductById(Long id) throws IOException {
        return productRepository.findProductById(id).orElse(null);
    }

    public Product findProductByName(String name) throws IOException {
        return productRepository.findProductByName(name).orElse(null);
    }

    public void deleteProductFromJson(Product product) throws IOException {
        productRepository.deleteProductFromJson(product);
    }

    public List<Product> filterByCategory(Integer category){
        return productList.getProductList().stream()
                .filter(n -> n.getProductCategory().ordinal() == category)
                .collect(Collectors.toList());
    }

    public List<Product> filterByCalories(Integer caloriesMin, Integer caloriesMax){
        return productList.getProductList().stream()
                .filter(cal -> cal.getCalories()<= caloriesMax && cal.getCalories() >= caloriesMin)
                .collect(Collectors.toList());
    }

    public Map<Shop, List<Product>> filterByPriceAndGroupByShop(Integer priceMin, Integer priceMax){
        return productList.getProductList().stream()
                .filter(n -> n.getPrice() <= priceMax && n.getPrice()>= priceMin)
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.groupingBy(Product::getShop));

    }
}