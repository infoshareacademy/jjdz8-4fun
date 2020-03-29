package pl.fourfun.readwriteproducts;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pl.fourfun.menutypes.ReadProductMenu;

import java.io.*;
import java.util.*;

public class AddProductToUserList {

    public static void readAllProductsToUserList() throws IOException {
        FileReader jsonFileProductInput = null;
        JSONObject jsonObjectReader = null;
        try {
            jsonFileProductInput = new FileReader("Products.json");
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
                System.out.println("========================Lista produktow - START=======================================================");

                int maxNameLength = 0;
                int maxBrandLength = 0;
                int maxPriceLength = 0;
                int maxCloriesLength = 0;
                int maxShopLength = 0;
                int maxProductCategoryLength = 0;
                Integer IDProducts = 1;

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

                    System.out.print("ID: " + countSpacesAndUpdate(IDProducts.toString(), maxNameLength) + " || ");
                    System.out.print("Kategoria produktu: " + countSpacesAndUpdate(productDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
                    System.out.print("Nazwa: " + countSpacesAndUpdate(productDetail.get("name").toString(), maxNameLength) + " || ");
                    System.out.print("Producent: " + countSpacesAndUpdate(productDetail.get("brand").toString(), maxBrandLength) + " || ");
                    System.out.print("Cena: " + countSpacesAndUpdate(productDetail.get("price").toString(), maxPriceLength) + " || ");
                    System.out.print("Kaloryka: " + countSpacesAndUpdate(productDetail.get("calories").toString(), maxCloriesLength) + " || ");
                    System.out.println("Sklep: " + countSpacesAndUpdate(productDetail.get("shop").toString(), maxShopLength) + " || ");
                    IDProducts += 1;
                }
                System.out.println("========================Lista produktow - KONIEC======================================================");
                System.out.println("Podaj ID produktu , który chcesz dodać do listy : ");
                System.out.println("Wpisz 0 ,by powrócić do poprzedniego menu.");

                boolean counter = false;
                int choiceID = 0;
                while (!counter) {
                    Scanner inputUserText = new Scanner(System.in);
                    try {
                        choiceID = inputUserText.nextInt();
                        if( 0 == choiceID){
                            ReadProductMenu.readingProductMenu();
                            counter = true;
                            break;
                        };
                        if( 0 < choiceID && choiceID <= jsonArrayProducts.size()){
                            System.out.println("ok wartosc z zakresu");
                            counter = true;
                        }else
                        {
                            System.out.println("wybierz prawidlowa wartosc z ID, podaj prawidłową: ");
                        }
                    } catch (Exception e) {
                        System.out.println("wybierz prawidlowa wartosc z ID, podaj prawidłową: ");
                    }
                }

                IDProducts = 1;
                for (Iterator it = sortedJsonArrayProductsPerProduct.iterator(); it.hasNext(); ) {
                    Object objIterator = it.next();
                    org.json.JSONObject productDetail = (org.json.JSONObject) objIterator;
                    if(choiceID == IDProducts){

                        FileReader jsonFileProductInput2 = new FileReader("UserProductList.json");
                        JSONObject jsonObjectReader2 = (JSONObject) JSONValue.parse(jsonFileProductInput2);
                        JSONArray jsonArrayProducts2 = (JSONArray) jsonObjectReader2.get("productList");
                        System.out.println("wielosc jsonArrayProducts2 : "+jsonArrayProducts2.size());

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