package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.service.OptionsFromProductJsonFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Stateless
public class AdminRepositoryBean implements AdminRepository {

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
        jsonObjectNewProduct.put("id", jsonArrayProducts.size()+1);
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
    public Product findProductById(Integer id) throws IOException {
        return showAllProducts().getProductList().get(id);
    }

        @Override
    public void editProduct(Long id, Product product) throws IOException {
        Collections.replaceAll(showAllProducts().getProductList(), findProductById(Math.toIntExact(id)), product);
    }
}
