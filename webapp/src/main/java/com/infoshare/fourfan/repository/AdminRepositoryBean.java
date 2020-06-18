package com.infoshare.fourfan.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.servlet.config.WebInfPathResolver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.*;

@Stateless
public class AdminRepositoryBean implements AdminRepository {

    private static final String PRODUCTS_FILE_NAME = "Products.json";

    @Inject
    private WebInfPathResolver webInfPathResolver;

    Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void saveNewProduct(Product product) throws IOException {
        String jsonFilePath = webInfPathResolver.getFilePath(PRODUCTS_FILE_NAME);
        FileReader jsonFileProductInput = new FileReader(jsonFilePath);
        JSONObject jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);

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

        //dziala
//        Writer writer = new FileWriter(jsonFilePath);
//        jsonObjectReader.writeJSONString(writer);
//        writer.close();

        //nie dziala
//        new OptionsFromProductJsonFile().saveProductsJsonFile(jsonObjectReader);

        //dziala
        try (Writer writerProductsJsonFile = new FileWriter(jsonFilePath)) {
            GSON.toJson(jsonObjectReader, writerProductsJsonFile);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }
}
