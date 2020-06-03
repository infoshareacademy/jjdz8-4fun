package com.infoshare.fourfan.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.storage.ProductDb;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import java.io.*;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductRepositoryBean implements ProductRepository {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String PRODUCTS_JSON_FILE = "Products.json";

    @Override
    public void save(Product product) throws IOException {
        JSONObject jsonObjectReader = null;
        try {
            FileReader jsonFileProductInput = new FileReader("Products.json");
            jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);
        }catch(Exception e){
            System.out.println("brak pliku wsadowego.");
        }
        JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");

        JSONObject jsonObjectNewProduct = new JSONObject();
        jsonObjectNewProduct.put("name", product.getName());
        jsonObjectNewProduct.put("brand", product.getBrand());
        jsonObjectNewProduct.put("price", product.getPrice());
        jsonObjectNewProduct.put("calories", product.getCalories());
        jsonObjectNewProduct.put("shop", product.getShop().toString());
        jsonObjectNewProduct.put("productCategory", product.getProductCategory().toString());

        jsonArrayProducts.add(0, jsonObjectNewProduct);

        Writer writer = new FileWriter("Products.json");
        jsonObjectReader.writeJSONString(writer);
        writer.close();
    }


//    @Override
//    public void save(Product product) {
//        ProductDb.getRepository().add(product);
//    }

    @Override
    public Optional<Product> findByName(String name) throws IOException {
        return findAll().stream()
                .filter(product -> product.getName().equals(name)).findFirst();
    }

    @Override
    public List<Product> findAll() throws IOException {
        return ProductDb.getRepository();
    }

    @Override
    public void delete(Product product) throws IOException {
        ProductDb.getRepository().remove(product);

    }

    @Override
    public void saveProductsToJsonFile(ProductList productList) {
        try (Writer writer = new FileWriter(PRODUCTS_JSON_FILE)) {
            GSON.toJson(productList, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    @Override
    public ProductList readProductsJsonFile() {

        try (Reader reader = new FileReader(PRODUCTS_JSON_FILE)) {
            ProductList productList = GSON.fromJson(reader, ProductList.class);
            return productList;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return new ProductList();
    }
}
