package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.datatypes.ShoppingList;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.io.*;
import java.util.Objects;

@LocalBean
@Stateful
public abstract class JsonShoppingListService {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String PRODUCTS_JSON_FILE_2 = Objects.requireNonNull(JsonShoppingListService.class.getClassLoader().getResource("ShoppingList.json")).getPath();

    public static void saveProductShoppingListToJsonFile(ShoppingList shoppingList) {
        try (Writer writer = new FileWriter(PRODUCTS_JSON_FILE_2)) {
            GSON.toJson(shoppingList, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static ShoppingList readShoppingListJsonFile() {
        try (Reader reader = new FileReader(PRODUCTS_JSON_FILE_2)) {
            ShoppingList shoppingList = GSON.fromJson(reader, ShoppingList.class);
            return shoppingList;
        } catch (IOException e) {
            System.out.println("Products json file not found or broken: " + e.getMessage());
        }
        return new ShoppingList();
    }

    public static void removeAllShoppingList() throws IOException {

        JSONObject jsonObjectReader22 = (JSONObject) JSONValue.parse("{\"shoppingList\":[]}");
        JSONObject removeObject = new JsonSaveShoppingListService().saveShoppingListJsonFile(jsonObjectReader22);

    }

}