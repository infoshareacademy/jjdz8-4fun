package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.repository.ProductRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestScoped
public class ProductService {

    @EJB
    private ProductRepository productRepository;

    @EJB
    private ProductDao productDao;

    //------------------------------------------------------------

    public List<Product> findAllJson() throws IOException {
        return productRepository.findAllJson();
    }

    public Product findProductById(Integer id) throws IOException {
        return productRepository
                .findProductById(id)
                .orElse(null);
    }

    public Product findProductByName(String name) throws IOException {
        return productRepository
                .findProductByName(name)
                .orElse(null);
    }

    public List<Product> filterProductsByBrand(String brand) throws IOException {
        return productRepository
                .findAllProductsByBrand(brand);
    }

    public List<Product> filterProductsByPrice(Integer price) throws IOException {
        return productRepository
                .findAllProductsByPrice(price);
    }

    public List<Product> filterProductsByCalories(Integer calories) throws IOException {
        return productRepository
                .findAllProductsByCalories(calories);
    }

    public List<Product> filterProductsByCategory (ProductCategory category) throws IOException {
        return productRepository
                .findAllProductsByCategory(category);
    }

    public List<Product> filterProductsByShop (Shop shop) throws IOException {
        return productRepository
                .findAllProductsByShop(shop);
    }

    public List<Product> filterByCalories(Integer caloriesMin, Integer caloriesMax) {
        return productRepository.filterByCalories(caloriesMin, caloriesMax);
    }

    public void deleteProductFromJson(Product product) throws IOException {
        productRepository.deleteProductFromJson(product);
    }

    public List<Product> filterByCategory(Integer category) {
        return productRepository.filterByCategory(category);
    }

    public Map<Shop, List<Product>> filterByPriceAndGroupByShop(Integer priceMin, Integer priceMax) {
        return productRepository.filterByPriceAndGroupByShop(priceMin, priceMax);
    }

    public void saveToJson(Product product) throws IOException {
        productRepository.saveToJson(product);
    }
}
