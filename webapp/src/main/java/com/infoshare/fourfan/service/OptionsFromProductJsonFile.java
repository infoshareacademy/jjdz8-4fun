package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.servlet.config.WebInfPathResolver;
import org.json.simple.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@LocalBean
@Stateful
public class OptionsFromProductJsonFile {

    private static final String PRODUCTS_FILE_NAME = "Products.json";
    @Inject
    private WebInfPathResolver webInfPathResolver;

    Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public void saveProductsJsonFile(JSONObject inputNewProductsToProductsJsonFile) {
        String jsonFilePath = webInfPathResolver.getFilePath(PRODUCTS_FILE_NAME);

        try (Writer writerProductsJsonFile = new FileWriter(jsonFilePath)) {
            GSON.toJson(inputNewProductsToProductsJsonFile, writerProductsJsonFile);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }
}