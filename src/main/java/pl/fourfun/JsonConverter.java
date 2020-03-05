package pl.fourfun;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.fourfun.datatypes.ProductList;

import java.io.*;

public abstract class JsonConverter {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String PRODUCTS_JSON_FILE = "Products.json";

    public static void saveProductsToJsonFile(ProductList productList) {
        try (Writer writer = new FileWriter(PRODUCTS_JSON_FILE)) {
            GSON.toJson(productList, writer);
            //System.out.println("Products saved to json file:  " + PRODUCTS_JSON_FILE);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static ProductList readProductsJsonFile() {
        try (Reader reader = new FileReader(PRODUCTS_JSON_FILE)) {
            System.out.println("Reading Products from json file: " + PRODUCTS_JSON_FILE);
            ProductList productList = GSON.fromJson(reader, ProductList.class);
            System.out.println("Products successfully read.");
            return productList;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return new ProductList();
    }
}