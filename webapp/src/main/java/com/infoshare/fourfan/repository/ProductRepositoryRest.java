package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.exception.ProductNotFoundException;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class ProductRepositoryRest {

    private final Map<Integer, Product> products;

    public ProductRepositoryRest() {
        this.products = new HashMap<>();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void saveProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException(String.format("Product can not be null"));
        }
        products.put(product.getId(), product);
    }

    public Product getProduct(Integer id) {
        Product product = products.get(id);

        if (product == null) {
            throw new ProductNotFoundException(String.format("Product with id %s not found.", id));
        }

        Product productToReturn = new Product();

        productToReturn.setName(product.getName());
        productToReturn.setBrand(product.getBrand());
        productToReturn.setShop(product.getShop());
        productToReturn.setPrice(product.getPrice());
        productToReturn.setCalories(product.getCalories());
        productToReturn.setProductCategory(product.getProductCategory());
        productToReturn.setCreated(product.getCreated());
        productToReturn.setId(product.getId());

        return productToReturn;

    }

    public void removeProduct(Integer id) {
        Product product = products.get(id);

        if (product == null) {
            throw new ProductNotFoundException(String.format("Product with id %s not found.", id));
        }
        products.remove(id);
    }

}
