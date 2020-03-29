package pl.fourfun.readwriteproducts;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pl.fourfun.JsonConverterForProducts;
import pl.fourfun.datatypes.Product;
import pl.fourfun.datatypes.ProductList;
import pl.fourfun.menutypes.LoggedUserMenu;
import pl.fourfun.menutypes.ReadProductMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadProducts
{
    public static void readAllProducts() throws IOException, InterruptedException {
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
                    System.out.print("Nazwa: " + countSpacesAndUpdate(productDetail.get("name").toString(), maxNameLength) +  " || ");
                    System.out.print("Producent: " + countSpacesAndUpdate(productDetail.get("brand").toString(), maxBrandLength) + " || ");
                    System.out.print("Cena: " + countSpacesAndUpdate(productDetail.get("price").toString(), maxPriceLength) + " || ");
                    System.out.print("Kaloryka: " + countSpacesAndUpdate(productDetail.get("calories").toString(), maxCloriesLength) + " || ");
                    System.out.println("Sklep: " + countSpacesAndUpdate(productDetail.get("shop").toString(), maxShopLength) + " || ");
                }
                System.out.println("========================Lista produktow - KONIEC======================================================");

                ReadProductMenu.readingProductMenu();
            }
        }
    }

    public static void readChoiceCategoryProducts() throws IOException, InterruptedException {

        boolean counter = false;
        int selectedProductList = 0;
        String category = null;

        System.out.println("Kategorie produktów: ");
        System.out.println("1 - NABIAŁ");
        System.out.println("2 - OWOCE");
        System.out.println("3 - WARZYWA");
        System.out.println("4 - powrot do poprzedniego menu.");

        System.out.println("Podaj kategorie produktu: ");

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

        int maxNameLength = 0;
        int maxBrandLength = 0;
        int maxPriceLength = 0;
        int maxCloriesLength = 0;
        int maxShopLength = 0;
        int maxProductCategoryLength = 0;

        for (Iterator it = jsonArrayProducts.iterator(); it.hasNext(); ) {
            JSONObject productDetail = (JSONObject) it.next();
            if (productDetail.get("productCategory").equals(category)) {
                maxNameLength = Integer.max(maxNameLength, productDetail.get("name").toString().length());
                maxBrandLength = Integer.max(maxBrandLength, productDetail.get("brand").toString().length());
                maxPriceLength = Integer.max(maxPriceLength, productDetail.get("price").toString().length());
                maxCloriesLength = Integer.max(maxCloriesLength, productDetail.get("calories").toString().length());
                maxShopLength = Integer.max(maxShopLength, productDetail.get("shop").toString().length());
                maxProductCategoryLength = Integer.max(maxProductCategoryLength, productDetail.get("productCategory").toString().length());
                numberOfProduct += 1;
            }
        }

        for (Iterator it = jsonArrayProducts.iterator(); it.hasNext(); ) {
            JSONObject productDetail = (JSONObject) it.next();
            if (productDetail.get("productCategory").equals(category)) {
                System.out.print("Kategoria produktu: " + countSpacesAndUpdate(productDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
                System.out.print("Nazwa: " + countSpacesAndUpdate(productDetail.get("name").toString(), maxNameLength) +  " || ");
                System.out.print("Producent: " + countSpacesAndUpdate(productDetail.get("brand").toString(), maxBrandLength) + " || ");
                System.out.print("Cena: " + countSpacesAndUpdate(productDetail.get("price").toString(), maxPriceLength) + " || ");
                System.out.print("Kaloryka: " + countSpacesAndUpdate(productDetail.get("calories").toString(), maxCloriesLength) + " || ");
                System.out.println("Sklep: " + countSpacesAndUpdate(productDetail.get("shop").toString(), maxShopLength) + " || ");
            }
        }

        if(numberOfProduct == 0 ) System.out.println("Brak produktow w wybranej kategorii.");
        System.out.println("========================Lista produktow - KONIEC======================================================");

        ReadProductMenu.readingProductMenu();
    }




///////////////////////////////////////////////////////

    public static void readChoiceShopProducts() throws IOException, InterruptedException {

        boolean counter = false;
        int selectedShopList = 0;
        String shop = null;

        System.out.println("Sklepy do wyboru: ");
        System.out.println("1 - AUCHAN");
        System.out.println("2 - PIOTRiPAWEŁ");
        System.out.println("3 - TESCO");
        System.out.println("4 - powrot do poprzedniego menu.");

        System.out.println("Podaj nazwe sklepu: ");

        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                selectedShopList = userInputOption.nextInt();
            } catch (Exception e) {
            }
            switch (selectedShopList) {
                case 1:
                    shop = "AUCHAN";
                    counter = true;
                    break;
                case 2:
                    shop = "PIOTRiPAWEŁ";
                    counter = true;
                    break;
                case 3:
                    shop = "TESCO";
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

        int numberOfShop = 0;
        FileReader jsonFileShopInput = new FileReader("Products.json");
        JSONObject jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileShopInput);
        JSONArray jsonArrayShop = (JSONArray) jsonObjectReader.get("productList");
        System.out.println("========================Lista produktow - START======================================================");

        int maxNameLength = 0;
        int maxBrandLength = 0;
        int maxPriceLength = 0;
        int maxCloriesLength = 0;
        int maxShopLength = 0;
        int maxProductCategoryLength = 0;

        for (Iterator it = jsonArrayShop.iterator(); it.hasNext(); ) {
            JSONObject shopDetail = (JSONObject) it.next();
            if (shopDetail.get("shop").equals(shop)) {
                maxNameLength = Integer.max(maxNameLength, shopDetail.get("name").toString().length());
                maxBrandLength = Integer.max(maxBrandLength, shopDetail.get("brand").toString().length());
                maxPriceLength = Integer.max(maxPriceLength, shopDetail.get("price").toString().length());
                maxCloriesLength = Integer.max(maxCloriesLength, shopDetail.get("calories").toString().length());
                maxShopLength = Integer.max(maxShopLength, shopDetail.get("shop").toString().length());
                maxProductCategoryLength = Integer.max(maxProductCategoryLength, shopDetail.get("productCategory").toString().length());
                numberOfShop += 1;
            }
        }

        for (Iterator it = jsonArrayShop.iterator(); it.hasNext(); ) {
            JSONObject shopDetail = (JSONObject) it.next();
            if (shopDetail.get("shop").equals(shop)) {
                System.out.print("Kategoria produktu: " + countSpacesAndUpdate(shopDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
                System.out.print("Nazwa: " + countSpacesAndUpdate(shopDetail.get("name").toString(), maxNameLength) +  " || ");
                System.out.print("Producent: " + countSpacesAndUpdate(shopDetail.get("brand").toString(), maxBrandLength) + " || ");
                System.out.print("Cena: " + countSpacesAndUpdate(shopDetail.get("price").toString(), maxPriceLength) + " || ");
                System.out.print("Kaloryka: " + countSpacesAndUpdate(shopDetail.get("calories").toString(), maxCloriesLength) + " || ");
                System.out.println("Sklep: " + countSpacesAndUpdate(shopDetail.get("shop").toString(), maxShopLength) + " || ");
            }
        }

        if(numberOfShop == 0 ) System.out.println("Brak produktow w wybranej kategorii.");
        System.out.println("========================Lista produktow - KONIEC======================================================");

        ReadProductMenu.readingProductMenu();
    }

    public static void readChoiceBrandProducts() throws IOException, InterruptedException {

        boolean counter = false;
        String selectedBrandList = null;

        System.out.println("Podaj nazwe producenta: ");

        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                selectedBrandList = userInputOption.next();
                counter = true;
            } catch (Exception e) {
            }
            System.out.println(selectedBrandList);
        }
        int numberOfBrand = 0;
        FileReader jsonFileBrandInput = new FileReader("Products.json");
        JSONObject jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileBrandInput);
        JSONArray jsonArrayBrand = (JSONArray) jsonObjectReader.get("productList");
        System.out.println("========================Lista produktow - START======================================================");

        int maxNameLength = 0;
        int maxBrandLength = 0;
        int maxPriceLength = 0;
        int maxCloriesLength = 0;
        int maxShopLength = 0;
        int maxProductCategoryLength = 0;

        for (Iterator it = jsonArrayBrand.iterator(); it.hasNext(); ) {
            JSONObject brandDetail = (JSONObject) it.next();
            if (brandDetail.get("brand").toString().toLowerCase().contains(selectedBrandList)) {
                maxNameLength = Integer.max(maxNameLength, brandDetail.get("name").toString().length());
                maxBrandLength = Integer.max(maxBrandLength, brandDetail.get("brand").toString().length());
                maxPriceLength = Integer.max(maxPriceLength, brandDetail.get("price").toString().length());
                maxCloriesLength = Integer.max(maxCloriesLength, brandDetail.get("calories").toString().length());
                maxShopLength = Integer.max(maxShopLength, brandDetail.get("shop").toString().length());
                maxProductCategoryLength = Integer.max(maxProductCategoryLength, brandDetail.get("productCategory").toString().length());
                numberOfBrand += 1;
            }
        }

        for (Iterator it = jsonArrayBrand.iterator(); it.hasNext(); ) {
            JSONObject brandDetail = (JSONObject) it.next();
            if (brandDetail.get("brand").toString().toLowerCase().contains(selectedBrandList)) {
                System.out.print("Kategoria produktu: " + countSpacesAndUpdate(brandDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
                System.out.print("Nazwa: " + countSpacesAndUpdate(brandDetail.get("name").toString(), maxNameLength) +  " || ");
                System.out.print("Producent: " + countSpacesAndUpdate(brandDetail.get("brand").toString(), maxBrandLength) + " || ");
                System.out.print("Cena: " + countSpacesAndUpdate(brandDetail.get("price").toString(), maxPriceLength) + " || ");
                System.out.print("Kaloryka: " + countSpacesAndUpdate(brandDetail.get("calories").toString(), maxCloriesLength) + " || ");
                System.out.println("Sklep: " + countSpacesAndUpdate(brandDetail.get("shop").toString(), maxShopLength) + " || ");
            }
        }

        if(numberOfBrand == 0 ) System.out.println("Brak produktow w wybranej kategorii.");
        System.out.println("========================Lista produktow - KONIEC======================================================");

        ReadProductMenu.readingProductMenu();
    }

    public static void readChoiceNameProducts() throws IOException, InterruptedException {

        boolean counter = false;
        String selectedNameList = null;

        System.out.println("Podaj zawartosc nazwy produktu: ");

        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                selectedNameList = userInputOption.next();
                counter = true;
            } catch (Exception e) {
            }
            System.out.println(selectedNameList);
        }
        int numberOfName = 0;
        FileReader jsonFileNameInput = new FileReader("Products.json");
        JSONObject jsonObjectReader = (JSONObject) JSONValue.parse(jsonFileNameInput);
        JSONArray jsonArrayName = (JSONArray) jsonObjectReader.get("productList");
        System.out.println("========================Lista produktow - START======================================================");

        int maxNameLength = 0;
        int maxBrandLength = 0;
        int maxPriceLength = 0;
        int maxCloriesLength = 0;
        int maxShopLength = 0;
        int maxProductCategoryLength = 0;

        for (Iterator it = jsonArrayName.iterator(); it.hasNext(); ) {
            JSONObject nameDetail = (JSONObject) it.next();
            if (nameDetail.get("name").toString().toLowerCase().contains(selectedNameList)) {
                maxNameLength = Integer.max(maxNameLength, nameDetail.get("name").toString().length());
                maxBrandLength = Integer.max(maxBrandLength, nameDetail.get("brand").toString().length());
                maxPriceLength = Integer.max(maxPriceLength, nameDetail.get("price").toString().length());
                maxCloriesLength = Integer.max(maxCloriesLength, nameDetail.get("calories").toString().length());
                maxShopLength = Integer.max(maxShopLength, nameDetail.get("shop").toString().length());
                maxProductCategoryLength = Integer.max(maxProductCategoryLength, nameDetail.get("productCategory").toString().length());
                numberOfName += 1;
            }
        }

        for (Iterator it = jsonArrayName.iterator(); it.hasNext(); ) {
            JSONObject nameDetail = (JSONObject) it.next();
            String nazwa = nameDetail.get("name").toString().toLowerCase();
            if (nameDetail.get("name").toString().toLowerCase().contains(selectedNameList)) {
                System.out.print("Kategoria produktu: " + countSpacesAndUpdate(nameDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
                System.out.print("Nazwa: " + countSpacesAndUpdate(nameDetail.get("name").toString(), maxNameLength) +  " || ");
                System.out.print("Producent: " + countSpacesAndUpdate(nameDetail.get("brand").toString(), maxBrandLength) + " || ");
                System.out.print("Cena: " + countSpacesAndUpdate(nameDetail.get("price").toString(), maxPriceLength) + " || ");
                System.out.print("Kaloryka: " + countSpacesAndUpdate(nameDetail.get("calories").toString(), maxCloriesLength) + " || ");
                System.out.println("Sklep: " + countSpacesAndUpdate(nameDetail.get("shop").toString(), maxShopLength) + " || ");
            }
        }

        if(numberOfName == 0 ) System.out.println("Brak produktow w wybranej kategorii.");
        System.out.println("========================Lista produktow - KONIEC======================================================");

        ReadProductMenu.readingProductMenu();
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