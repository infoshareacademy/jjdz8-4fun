package pl.fourfun.readwriteproducts;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pl.fourfun.menutypes.LoggedUserMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadProducts
{
    public static void readAllProducts() {
        FileReader jsonFileProductInput = null;
        JSONObject jsonObjectReader = null;
        try {
            jsonFileProductInput = new FileReader("Products.json");
            jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);
        }catch (FileNotFoundException e){
            System.out.println("Brak pliku wsadowego z produktami.");
        } catch(Exception e){
            System.out.println("Niespodziewany problem pliku wsadowego z produktami.");
        }
        if(jsonObjectReader != null) {
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
                System.out.println("========================Lista produktow - START======================================================");

                for (Iterator it = sortedJsonArrayProductsPerProduct.iterator(); it.hasNext(); ) {
                    Object objIterator = it.next();
                    org.json.JSONObject productDetail = (org.json.JSONObject) objIterator;
                    System.out.println("Kategoria: " + productDetail.get("productCategory") + "\t - Nazwa: " + productDetail.get("name") + "\t - Marka: " + productDetail.get("brand") + "\t - Cena: " + productDetail.get("price") + "\t - Kalorycznosc: " + productDetail.get("calories") + "\t - Sklep: " + productDetail.get("shop"));
                }
            }
        }
        System.out.println("========================Lista produktow - KONIEC======================================================");
    }

    public static void readChoiceProducts() throws IOException, InterruptedException {

        boolean counter = false;
        int selectedProductList = 0;
        String category = null;

        System.out.println("Podaj kategorie produktu: ");
        System.out.println("1 - NABIAŁ");
        System.out.println("2 - OWOCE");
        System.out.println("3 - WARZYWA");
        System.out.println("4 - powrot do poprzedniego menu.");

        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                selectedProductList = userInputOption.nextInt();
            } catch (Exception e) {
            }
            switch (selectedProductList) {
                case 1:
                    category = "NABIAŁ";
                    counter = true;
                    break;
                case 2:
                    category = "OWOCE";
                    counter = true;
                    break;
                case 3:
                    category = "WARZYWA";
                    counter = true;
                    break;
                case 4:
                    LoggedUserMenu.showUserMenu();
                    counter = true;
                    break;
                default: {
                    System.out.println("Niepoprawna operacja, wskaz prawidlowa (1,2,3 lub 4)");
                    break;
                }
            }
        }

        int numberOfProduct = 0;
        FileReader jsonFileProductInput = new FileReader("Products.json");
        JSONObject jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileProductInput);
        JSONArray jsonArrayProducts = (JSONArray) jsonObjectReader.get("productList");
        System.out.println("========================Lista produktow - START======================================================");
        for (Iterator it = jsonArrayProducts.iterator(); it.hasNext(); ) {
            JSONObject productDetail = (JSONObject) it.next();
            if (productDetail.get("productCategory").equals(category)) {
                numberOfProduct += 1;
                System.out.println("Kategoria: " + productDetail.get("productCategory") + "\t - Nazwa: " + productDetail.get("name") + "\t - Marka: " + productDetail.get("brand") + "\t - Cena: " + productDetail.get("price") + "\t - Kalorycznosc: " + productDetail.get("calories") + "\t - Sklep: " + productDetail.get("shop"));
            }
        }
        if(numberOfProduct == 0 ) System.out.println("Brak produktow w wybranej kategorii.");
        System.out.println("========================Lista produktow - KONIEC======================================================");
    }
}