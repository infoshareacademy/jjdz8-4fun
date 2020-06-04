package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.service.JsonService;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public void saveToJson(ProductList productList) {
        JsonService.saveProductsToJsonFile(productList);
    }

    @Override
    public void deleteProductFromJson(Product product) throws IOException {

    }


}
