package com.infoshare.fourfan.storage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.servlet.utils.WebInfPathResolver;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.*;
import java.util.logging.Logger;

@Stateful
public class ProductsJsonStorage {

    public static final String PRODUCTS_FILE_NAME = "Products.json";

    @Inject
    private WebInfPathResolver webInfPathResolver;

    private Logger logger = Logger.getLogger(ProductsJsonStorage.class.getName());

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public ProductList load() {
        try (Reader reader = new FileReader(this.getProductsRepositoryPath())) {
            ProductList productList = this.gson.fromJson(reader, ProductList.class);
            return productList;
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
        return new ProductList();
    }

    public void save(ProductList productList) {
        try (Writer writer = new FileWriter(this.getProductsRepositoryPath())) {
            this.gson.toJson(productList, writer);
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    private String getProductsRepositoryPath() {
        return !webInfPathResolver.getJsonRepositoryPath().isEmpty() ?
                webInfPathResolver.getJsonRepositoryPath() + PRODUCTS_FILE_NAME :
                Resources.getResource(PRODUCTS_FILE_NAME).getPath();
    }
}