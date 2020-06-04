package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.ProductList;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.io.*;
import java.util.*;

@LocalBean
@Stateful
public abstract class JsonService {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String PRODUCTS_JSON_FILE = Objects.requireNonNull(JsonService.class.getClassLoader().getResource("Products.json")).getPath();

    public static void saveProductsToJsonFile(ProductList productList) {
        try (Writer writer = new FileWriter(PRODUCTS_JSON_FILE)) {
            GSON.toJson(productList, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static ProductList readProductsJsonFile() {
        try (Reader reader = new FileReader(PRODUCTS_JSON_FILE)) {
            ProductList productList = GSON.fromJson(reader, ProductList.class);
            return productList;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return new ProductList();
    }
}
