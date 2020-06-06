package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class OptionsFromProductJsonFile {

    Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    String jsonFilePath = this.getClass().getClassLoader().getResource("Products.json").getPath();

    public JSONObject readProductsJsonFile() {
        JSONObject jsonObjectReader = null;
        try (FileReader reader = new FileReader(jsonFilePath)) {
            jsonObjectReader = GSON.fromJson(reader, JSONObject.class);
            return jsonObjectReader;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return null;
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