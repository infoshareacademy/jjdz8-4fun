package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.service.OptionsFromProductJsonFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@Stateless
public class AdminRepositoryBean implements AdminRepository {

    /*
    metoda roboczaShowAllProducts - jest tylko na potrzeby weryfikacji poprawnosci dodania produktu
    do pliku json, analogicznie serwlet - RoboczyServletShowProduct
     */
    public JSONObject roboczaShowAllProducts() {
        return new OptionsFromProductJsonFile().readProductsJsonFile();
    }

    @Override
    public void saveNewProduct(Product product) throws IOException {
        JSONObject jsonObjectReader = null;
        String abc = Objects.requireNonNull(this.getClass().getClassLoader().getResource("Products.json")).getPath();
        FileReader jsonFileProductInput = new FileReader(abc);

        jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);

        JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");
        JSONObject jsonObjectNewProduct = new JSONObject();
        jsonObjectNewProduct.put("name", product.getName());
        jsonObjectNewProduct.put("brand", product.getBrand());
        jsonObjectNewProduct.put("price", product.getPrice());
        jsonObjectNewProduct.put("calories", product.getCalories());
        jsonObjectNewProduct.put("shop", product.getShop().toString());
        jsonObjectNewProduct.put("productCategory", product.getProductCategory().toString());
        jsonObjectNewProduct.put("amount", 1);

        jsonArrayProducts.add(0, jsonObjectNewProduct);

        JSONObject zxc = new OptionsFromProductJsonFile().saveProductsJsonFile(jsonObjectReader);
    }
}
