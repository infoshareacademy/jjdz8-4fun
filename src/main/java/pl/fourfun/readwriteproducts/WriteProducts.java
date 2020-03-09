package pl.fourfun.readwriteproducts;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pl.fourfun.datatypes.ProductCategory;
import pl.fourfun.datatypes.Shop;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteProducts {

    public static void writingProduct(String name, String brand, Integer price, Integer calories, Shop shop, ProductCategory productCategory) throws IOException {
        JSONObject jsonObjectReader = null;
        try {
            FileReader jsonFileProductInput = new FileReader("Products.json");
            jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);
        }catch(Exception e){
            System.out.println("brak pliku wsadowego.");
        }
        JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");

        JSONObject jsonObjectNewProduct = new JSONObject();
        jsonObjectNewProduct.put("name", name);
        jsonObjectNewProduct.put("brand", brand);
        jsonObjectNewProduct.put("price", price);
        jsonObjectNewProduct.put("calories", calories);
        jsonObjectNewProduct.put("shop", shop.toString());
        jsonObjectNewProduct.put("productCategory", productCategory.toString());

        jsonArrayProducts.add(0, jsonObjectNewProduct);

        Writer writer = new FileWriter("Products.json");
        jsonObjectReader.writeJSONString(writer);
        writer.close(); }
}
