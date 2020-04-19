package pl.fourfun.readwriteproducts;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pl.fourfun.menutypes.ReadProductMenu;

import java.io.*;
import java.util.*;

public class ReadUserProducts {

    public static void readAllProductsUserList() throws IOException, InterruptedException {
        FileReader jsonFileProductInput = null;
        JSONObject jsonObjectReader = null;
        try {
            jsonFileProductInput = new FileReader("UserProductList.json");
            jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku wsadowego z produktami.");
        } catch (Exception e) {
            System.out.println("Niespodziewany problem pliku wsadowego z produktami.");
        }
        if (jsonObjectReader != null) {
            for (Object i : jsonObjectReader.keySet()) {
                JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");
                String stringProducts = jsonArrayProducts.toString();
                org.json.JSONArray jsonArrayProductsPerProduct = new org.json.JSONArray(stringProducts);
                JSONArray sortedJsonArrayProductsPerProduct = new JSONArray();
                List listProduct = new ArrayList();
                for (int j = 0; j < jsonArrayProductsPerProduct.length(); j++) {
                    listProduct.add(jsonArrayProductsPerProduct.getJSONObject(j));
                }
                Collections.sort(listProduct, new Comparator() {

                    private static final String KEY_NAME1 = "productCategory";

                    @Override
                    public int compare(Object a, Object b) {
                        org.json.JSONObject aa = (org.json.JSONObject) a;
                        org.json.JSONObject bb = (org.json.JSONObject) b;

                        String str1 = new String();
                        String str2 = new String();
                        try {
                            str1 = (String) aa.get(KEY_NAME1);
                            str2 = (String) bb.get(KEY_NAME1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return str1.compareTo(str2);
                    }
                });
                for (int k = 0; k < jsonArrayProductsPerProduct.length(); k++) {
                    sortedJsonArrayProductsPerProduct.add(listProduct.get(k));
                }
                System.out.println("========================Wlasna lista zakupow - START=======================================================");

                int maxNameLength = 0;
                int maxBrandLength = 0;
                int maxPriceLength = 0;
                int maxCloriesLength = 0;
                int maxShopLength = 0;
                int maxProductCategoryLength = 0;

                for (Iterator it = sortedJsonArrayProductsPerProduct.iterator(); it.hasNext(); ) {
                    Object objIterator = it.next();
                    org.json.JSONObject productDetail = (org.json.JSONObject) objIterator;

                    maxNameLength = Integer.max(maxNameLength, productDetail.get("name").toString().length());
                    maxBrandLength = Integer.max(maxBrandLength, productDetail.get("brand").toString().length());
                    maxPriceLength = Integer.max(maxPriceLength, productDetail.get("price").toString().length());
                    maxCloriesLength = Integer.max(maxCloriesLength, productDetail.get("calories").toString().length());
                    maxShopLength = Integer.max(maxShopLength, productDetail.get("shop").toString().length());
                    maxProductCategoryLength = Integer.max(maxProductCategoryLength, productDetail.get("productCategory").toString().length());
                }
                for (Iterator it = sortedJsonArrayProductsPerProduct.iterator(); it.hasNext(); ) {
                    Object objIterator = it.next();
                    org.json.JSONObject productDetail = (org.json.JSONObject) objIterator;
                    System.out.print("Kategoria produktu: " + countSpacesAndUpdate(productDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
                    System.out.print("Nazwa: " + countSpacesAndUpdate(productDetail.get("name").toString(), maxNameLength) + " || ");
                    System.out.print("Producent: " + countSpacesAndUpdate(productDetail.get("brand").toString(), maxBrandLength) + " || ");
                    System.out.print("Cena: " + countSpacesAndUpdate(productDetail.get("price").toString(), maxPriceLength) + " || ");
                    System.out.print("Kaloryka: " + countSpacesAndUpdate(productDetail.get("calories").toString(), maxCloriesLength) + " || ");
                    System.out.println("Sklep: " + countSpacesAndUpdate(productDetail.get("shop").toString(), maxShopLength) + " || ");
                }
                System.out.println("========================Wlasna lista zakupow - KONIEC======================================================");

                ReadProductMenu.readingUserProductMenu();
            }
        }
    }

    public static String countSpacesAndUpdate(String name, int maxLength){
        int countSpaces = maxLength - name.length();
        String spaces = "";
        for(int i = 0; i < countSpaces; i++){
            spaces = spaces + " ";
        }
        return name + spaces;
    }

}