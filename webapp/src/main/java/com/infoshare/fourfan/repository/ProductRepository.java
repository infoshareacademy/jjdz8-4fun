package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.Shop;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Local
public interface ProductRepository {

    List<Product> findAllJson() throws IOException;

    Optional<Product> findProductById(Integer id) throws IOException;

    Optional<Product> findProductByName(String name) throws IOException;

    List<Product> findAllProductsByBrand(String brand) throws IOException;

    List<Product> findAllProductsByPrice(Integer price) throws IOException;

    List<Product> findAllProductsByCalories(Integer calories) throws IOException;

    List<Product> findAllProductsByCategory(ProductCategory productCategory) throws IOException;

    List<Product> findAllProductsByShop(Shop shop) throws IOException;

    void saveToJson(Product product) throws IOException;

    void deleteProductFromJson(Product product) throws IOException;

    List<Product> filterByCategory(Integer category);

    List<Product> filterByCalories(Integer caloriesMin, Integer caloriesMax);

    Map<Shop, List<Product>> filterByPriceAndGroupByShop(Integer priceMin, Integer priceMax);

}
