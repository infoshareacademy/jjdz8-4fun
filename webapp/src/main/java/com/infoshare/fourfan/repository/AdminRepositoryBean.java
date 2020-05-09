package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Stateless
public class AdminRepositoryBean implements AdminRepository {

    @Override
    public void save(Product product) throws IOException {
        JSONObject jsonObjectReader = null;
        try {
            FileReader jsonFileProductInput = new FileReader("Products.json");
            jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);
        }catch(Exception e){
            System.out.println("brak pliku wsadowego.");
        }
        JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");

        JSONObject jsonObjectNewProduct = new JSONObject();
        jsonObjectNewProduct.put("name", product.getName());
        jsonObjectNewProduct.put("brand", product.getBrand());
        jsonObjectNewProduct.put("price", product.getPrice());
        jsonObjectNewProduct.put("calories", product.getCalories());
        jsonObjectNewProduct.put("shop", product.getShop().toString());
        jsonObjectNewProduct.put("productCategory", product.getProductCategory().toString());

        jsonArrayProducts.add(0, jsonObjectNewProduct);

        Writer writer = new FileWriter("Products.json");
        jsonObjectReader.writeJSONString(writer);
        writer.close();
    }
}
