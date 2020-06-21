package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import org.json.simple.JSONObject;

import java.io.*;

public class OptionsFromProductJsonFile {

    Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    String jsonFilePath = this.getClass().getClassLoader().getResource("Products.json").getPath();

    public ProductList readProductsJsonFile() {
        try (Reader reader = new FileReader(jsonFilePath)) {
            ProductList productList = GSON.fromJson(reader, ProductList.class);
            return productList;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return new ProductList();
    }

    public JSONObject saveProductsJsonFile(JSONObject inputNewProductsToProductsJsonFile) {

        try (Writer writerProductsJsonFile = new FileWriter(jsonFilePath)) {
            GSON.toJson(inputNewProductsToProductsJsonFile, writerProductsJsonFile);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
        return inputNewProductsToProductsJsonFile;
    }
}