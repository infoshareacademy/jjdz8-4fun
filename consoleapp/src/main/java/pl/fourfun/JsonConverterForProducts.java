package pl.fourfun;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.fourfun.datatypes.ProductList;

import java.io.*;

public abstract class JsonConverterForProducts {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String PRODUCTS_JSON_FILE = "Products.json";

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