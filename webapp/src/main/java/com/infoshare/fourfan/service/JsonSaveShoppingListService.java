package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.ShoppingList;
import org.json.simple.JSONObject;

import java.io.*;

public class JsonSaveShoppingListService {

    Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    String jsonFilePath2 = this.getClass().getClassLoader().getResource("ShoppingList.json").getPath();

    public ShoppingList readProductsJsonFile() {
        try (Reader reader = new FileReader(jsonFilePath2)) {

            ShoppingList shoppingList = GSON.fromJson(reader, ShoppingList.class);
            return shoppingList;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return new ShoppingList();
    }

    public JSONObject saveShoppingListJsonFile(JSONObject inputNewProductsToShoppingListJsonFile) {

        try (Writer writerProductsJsonFile = new FileWriter(jsonFilePath2)) {
            GSON.toJson(inputNewProductsToShoppingListJsonFile, writerProductsJsonFile);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
        return inputNewProductsToShoppingListJsonFile;
    }
}