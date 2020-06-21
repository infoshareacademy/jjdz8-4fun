package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.Dao;
import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.repository.ProductRepository;
import org.json.simple.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public void saveToJson(Product product) throws IOException {
        productRepository.saveToJson(product);
    }

    public Product findProductById(Integer id) throws IOException {
        return productRepository.findProductById(id).orElse(null);
    }

    public Product findProductByName(String name) throws IOException {
        return productRepository.findProductByName(name).orElse(null);
    }

    public void deleteProductFromJson(Product product) throws IOException {
        productRepository.deleteProductFromJson(product);
    }

    public List<Product> filterByCategory(Integer category) {
        return productRepository.filterByCategory(category);
    }

    public List<Product> filterByCalories(Integer caloriesMin, Integer caloriesMax){
        return productRepository.filterByCalories(caloriesMin, caloriesMax);
    }

    public Map<Shop, List<Product>> filterByPriceAndGroupByShop(Integer priceMin, Integer priceMax){
        return productRepository.filterByPriceAndGroupByShop(priceMin, priceMax);
    }
}
