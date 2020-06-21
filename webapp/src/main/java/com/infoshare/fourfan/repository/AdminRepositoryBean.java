package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.service.JsonService;
import com.infoshare.fourfan.service.OptionsFromProductJsonFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Stateless
public class AdminRepositoryBean implements AdminRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductList showAllProducts() throws IOException {
        return new OptionsFromProductJsonFile().readProductsJsonFile();
    }

    @Override
    public void saveNewProduct(Product product) throws IOException {
        JSONObject jsonObjectReader = null;
        String abc = Objects.requireNonNull(this.getClass().getClassLoader().getResource("Products.json")).getPath();
        FileReader jsonFileProductInput = new FileReader(abc);

        jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);

        JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");
        JSONObject jsonObjectNewProduct = new JSONObject();
        jsonObjectNewProduct.put("id", jsonArrayProducts.size() + 1);
        jsonObjectNewProduct.put("name", product.getName());
        jsonObjectNewProduct.put("brand", product.getBrand());
        jsonObjectNewProduct.put("price", product.getPrice());
        jsonObjectNewProduct.put("calories", product.getCalories());
        jsonObjectNewProduct.put("shop", product.getShop().toString());
        jsonObjectNewProduct.put("productCategory", product.getProductCategory().toString());
        jsonObjectNewProduct.put("amount", 1);

        jsonArrayProducts.add(0, jsonObjectNewProduct);

        JSONObject zxc = new OptionsFromProductJsonFile().saveProductsJsonFile(jsonObjectReader);
    }

    @Override
    public Optional<Product> findProductById(Integer id) throws IOException {
        return showAllProducts().getProductList().stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public void editProduct(Integer id, Product newProduct) throws IOException {
        ProductList productList = showAllProducts();
        productList.set(id, newProduct);
        JsonService.saveProductsToJsonFile(productList);
    }
}
