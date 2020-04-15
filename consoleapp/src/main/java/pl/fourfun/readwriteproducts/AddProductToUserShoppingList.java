package pl.fourfun.readwriteproducts;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.*;

public class AddProductToUserShoppingList {

    public static void addProductToUserCart(JSONArray sortedJsonArrayProductsPerProduct, int choiceID) throws IOException {
        Integer IDProducts;

        IDProducts = 1;
        for (Iterator it = sortedJsonArrayProductsPerProduct.iterator(); it.hasNext(); ) {
            Object objIterator = it.next();
            org.json.JSONObject productDetail = (org.json.JSONObject) objIterator;
            if (choiceID == IDProducts) {

                FileReader jsonFileProductInput2 = new FileReader("UserProductList.json");
                JSONObject jsonObjectReader2 = (JSONObject) JSONValue.parse(jsonFileProductInput2);
                JSONArray jsonArrayProducts2 = (JSONArray) jsonObjectReader2.get("productList");
                System.out.println("wielkosc jsonArrayProducts2 : " + jsonArrayProducts2.size());

                int idProduktuListaDoADD2 = jsonArrayProducts2.size();
                JSONObject milestone12 = new JSONObject();
                milestone12.put("name", productDetail.get("name").toString());
                milestone12.put("brand", productDetail.get("brand").toString());
                milestone12.put("price", productDetail.get("price").toString());
                milestone12.put("calories", productDetail.get("calories").toString());
                milestone12.put("shop", productDetail.get("shop").toString());
                milestone12.put("productCategory", productDetail.get("productCategory").toString());

                jsonArrayProducts2.add(idProduktuListaDoADD2, milestone12);

                Writer writer2 = new FileWriter("UserProductList.json");
                jsonObjectReader2.writeJSONString(writer2);
                writer2.close();
            }
            IDProducts += 1;
        }
    }
}
