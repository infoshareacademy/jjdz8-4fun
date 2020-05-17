package pl.fourfun.menutypes;

import org.json.simple.JSONArray;
import pl.fourfun.readwriteproducts.AddProductToUserShoppingList;
import pl.fourfun.readwriteproducts.EditUserListOLD;
import pl.fourfun.readwriteproducts.ReadProducts;
import pl.fourfun.readwriteproducts.ReadUserProducts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import static pl.fourfun.menutypes.LoggedUserMenu.showUserMenu;
import static pl.fourfun.menutypes.Menu.clearMenu;

public class ReadProductMenu {

    public static void readingProductMenu() throws IOException, InterruptedException {

        int optionMenu = 0;
        boolean counter = false;

        System.out.println("===== menu wyswietlenie produktow =====");
        System.out.println("1 - wyswietlenie pelnej listy produktow.");
        System.out.println("2 - wyswietlenie listy produktow dla wskazanej kategorii.");
        System.out.println("3 - powrot do poprzedniego menu.");
        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                optionMenu = userInputOption.nextInt();
            } catch (Exception e) {
            }
            switch (optionMenu) {
                case 1:
                    clearMenu();
                    System.out.println("wczytanie pelnej listy produktow.");
                    ReadProducts.readAllProducts();
                    counter = true;
                    break;
                case 2:
                    clearMenu();
                    System.out.println("wczytanie listy produktow dla wskazanych kryteriow.");
                    SelectCriteriaProductMenu.selectingCriteriaProductMenu();
                    counter = true;
                    break;
                case 3:
                    clearMenu();
                    System.out.println("powrot do poprzedniego menu.");
                    LoggedAdminMenu.showAdminMenu();
                    counter = true;
                    break;
                default:
                    System.out.println("Niepoprawna operacja, wskaz prawidlowa (1-3)");
                    break;
            }
        }
    }

    public static void readingUserProductMenu() throws IOException, InterruptedException {

        int optionMenu = 0;
        boolean counter = false;

        System.out.println("===== menu wyswietlenie produktow =====");
        System.out.println("1 - wyswietlenie wlasnej listy zakupow.");
        System.out.println("2 - powrot do poprzedniego menu.");
        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                optionMenu = userInputOption.nextInt();
            } catch (Exception e) {
            }
            switch (optionMenu) {
                case 1:
                    clearMenu();
                    System.out.println("wyswietlenie wlasnej listy zakupow.");
                    ReadUserProducts.readAllProductsUserList();
                    counter = true;
                    break;
                case 2:
                    clearMenu();
                    System.out.println("powrot do poprzedniego menu.");
                    showUserMenu();
                    counter = true;
                    break;
                default:
                    System.out.println("Niepoprawna operacja, wskaz prawidlowa (1-2)");
                    break;
            }
        }
    }

    public static void readingAddedUserProductMenu() throws IOException, InterruptedException {

        int optionMenu = 0;
        boolean counter = false;

        System.out.println("===== menu wyświetlenie produktów =====");
        System.out.println("1 - dodanie produktu do własnej listy zakupów.");
        System.out.println("2 - edycja ilości produktu na liście zakupów");
        System.out.println("3 - usunięcie produktu z własnej listy zakupów");
        System.out.println("4 - usunięcie całej listy zakupów");
        System.out.println("5 - powrót do poprzedniego menu.");
        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                optionMenu = userInputOption.nextInt();
            } catch (Exception e) {
            }
            switch (optionMenu) {
                case 1:
                    clearMenu();
                    System.out.println("dodanie produktu do własnej listy zakupów.");
                    AddProductToUserShoppingList.readAllProductsToUserList();
                    ReadProductMenu.readingUserProductMenu();
                    counter = true;
                    break;
                case 2:
                    clearMenu();
                    System.out.println("edycja ilości");
                    EditUserListOLD.changeAmount();
                    counter = true;
                    break;
                case 3:
                    clearMenu();
                    System.out.println("usunięcie produktu ");
                    EditUserListOLD.removeOneFromUserList();
                    counter = true;
                    break;
                case 4:
                    clearMenu();
                    System.out.println("usunięcie całej listy");
                    EditUserListOLD.removeAllProductsFromUserList();
                    counter = true;
                    break;

                case 5:
                    clearMenu();
                    System.out.println("powrót do poprzedniego menu.");
                    showUserMenu();
                    counter = true;
                    break;
                default:
                    System.out.println("Niepoprawna operacja, wskaż prawidłowa (1-5)");
                    break;
            }
        }
    }

    public static void readAllProductsToUserList() throws IOException {
        JSONArray sortedJsonArrayProductsPerProduct = ReadProducts.getSortedProductList();
        int choiceID = chooseProductIDToAddToCart(sortedJsonArrayProductsPerProduct);
        AddProductToUserShoppingList.addProductToUserCart(sortedJsonArrayProductsPerProduct, choiceID);
    }

    public static int chooseProductIDToAddToCart(JSONArray sortedJsonArrayProductsPerProduct) {
        System.out.println("========================Lista produktów - START=======================================================");

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

            System.out.print("ID: " + ReadProducts.countSpacesAndUpdate(IDProducts.toString(), maxNameLength) + " || ");
            System.out.print("Kategoria produktu: " + ReadProducts.countSpacesAndUpdate(productDetail.get("productCategory").toString(), maxProductCategoryLength) + " || ");
            System.out.print("Nazwa: " + ReadProducts.countSpacesAndUpdate(productDetail.get("name").toString(), maxNameLength) + " || ");
            System.out.print("Producent: " + ReadProducts.countSpacesAndUpdate(productDetail.get("brand").toString(), maxBrandLength) + " || ");
            System.out.print("Cena: " + ReadProducts.countSpacesAndUpdate(productDetail.get("price").toString(), maxPriceLength) + " || ");
            System.out.print("Kaloryka: " + ReadProducts.countSpacesAndUpdate(productDetail.get("calories").toString(), maxCloriesLength) + " || ");
            System.out.println("Sklep: " + ReadProducts.countSpacesAndUpdate(productDetail.get("shop").toString(), maxShopLength) + " || ");
            IDProducts += 1;
        }
        System.out.println("========================Lista produktów - KONIEC======================================================");
        System.out.println("Podaj ID produktu , który chcesz dodać do listy : ");
        System.out.println("Wpisz 0 ,by powrócić do poprzedniego menu.");

        boolean counter = false;
        int choiceID = 0;
        while (!counter) {
            Scanner inputUserText = new Scanner(System.in);
            try {
                choiceID = inputUserText.nextInt();
                if (0 == choiceID) {
                    showUserMenu();
                    counter = true;
                    break;
                }
                if (0 < choiceID && choiceID <= sortedJsonArrayProductsPerProduct.size()) {
                    clearMenu();
                    System.out.println("[ok dodałem produkt do własnej listy]");
                    counter = true;
                    readAllProductsToUserList();
                    break;
                } else {
                    System.out.println("wybierz prawidłową wartość z ID, podaj prawidłową: ");
                }
            } catch (Exception e) {
                System.out.println("wybierz prawidłową wartość z ID, podaj prawidłową: ");
            }
        }
        return choiceID;
    }
}
