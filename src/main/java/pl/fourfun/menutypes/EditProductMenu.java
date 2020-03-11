package pl.fourfun.menutypes;

import pl.fourfun.JsonConverterForProducts;
import pl.fourfun.datatypes.Product;
import pl.fourfun.datatypes.ProductCategory;
import pl.fourfun.datatypes.ProductList;
import pl.fourfun.datatypes.Shop;
import java.util.Scanner;

import static pl.fourfun.Menu.clearMenu;


public class EditProductMenu {
    private static int numberOfProduct;
    private static Scanner scanner;

    public static void editingProductMethod() {
        scanner = new Scanner(System.in);
        ProductList productList = JsonConverterForProducts.readProductsJsonFile();

        while (true) {
            displayProductList(productList);
            do {
                System.out.println();
                System.out.println("Wybierz numer produktu na liście, który chcesz edytować lub wciśnij 0 by wrócić do menu Użytkownika : ");
                numberOfProduct = scanner.nextInt();
            } while (numberOfProduct > productList.size() || numberOfProduct < -1);
            if (numberOfProduct == 0) {
                JsonConverterForProducts.saveProductsToJsonFile(productList);
                return;
            }
            productList = editingChosenProduct(productList, numberOfProduct);
        }
    }

    private static void displayProductList(ProductList productList) {
        clearMenu();
        System.out.println("Twoja list produktów:");
        int maxNameLength = 0;
        int maxBrandLength = 0;
        int maxPriceLength = 0;
        int maxCloriesLength = 0;
        int maxShopLength = 0;
        int maxProductCategoryLength = 0;
        for(Product product : productList.getProductList()){
            maxNameLength = Integer.max(maxNameLength, product.getName().length());
            maxBrandLength = Integer.max(maxBrandLength, product.getBrand().length());
            maxPriceLength = Integer.max(maxPriceLength, product.getPrice().toString().length());
            maxCloriesLength = Integer.max(maxCloriesLength, product.getCalories().toString().length());
            maxShopLength = Integer.max(maxShopLength, product.getShop().toString().length());
            maxProductCategoryLength = Integer.max(maxProductCategoryLength, product.getProductCategory().toString().length());
        }
        for (int i = 0; i < productList.size(); i++) {
            System.out.println();
            System.out.println("Produkt numer " + (i + 1) + ": ");
            System.out.print("Nazwa: " + countSpacesAndUpdate(productList.get(i).getName(), maxNameLength) +  " || ");
            System.out.print("Producent: " + countSpacesAndUpdate(productList.get(i).getBrand(), maxBrandLength) + " || ");
            System.out.print("Cena: " + countSpacesAndUpdate(productList.get(i).getPrice().toString(), maxPriceLength) + " || ");
            System.out.print("Kaloryka: " + countSpacesAndUpdate(productList.get(i).getCalories().toString(), maxCloriesLength) + " || ");
            System.out.print("Sklep: " + countSpacesAndUpdate(productList.get(i).getShop().toString(), maxShopLength) + " || ");
            System.out.print("Kategoria produktu: " + countSpacesAndUpdate(productList.get(i).getProductCategory().toString(), maxProductCategoryLength) + " || ");
            System.out.println();
        }
    }

    public static ProductList editingChosenProduct(ProductList productList, int i) {
        while (true) {
            clearMenu();
            System.out.println("Edytujesz produkt: " + productList.get(i - 1).getName());
            System.out.println();
            System.out.println("Wybierz czynność:");
            System.out.println("1. Edytuj nazwę");
            System.out.println("2. Edytuj producenta");
            System.out.println("3. Edytuj cenę");
            System.out.println("4. Edytuj kalorykę");
            System.out.println("5. Edytuj sklep");
            System.out.println("6. Edytuj kategorię produktu");
            System.out.println("7. Usuń produkt");
            System.out.println("8. Wróć do listy produktów do edycji");

            int chooseActionNumber;
            do {
                chooseActionNumber = scanner.nextInt();
            } while (chooseActionNumber > 8 || chooseActionNumber < 0);

            switch (chooseActionNumber) {
                case 1:
                    clearMenu();
                    System.out.println("Podaj nową nazwę produktu");
                    productList.set(i - 1, editProductName(productList.get(i - 1)));
                    break;
                case 2:
                    clearMenu();
                    System.out.println("Podaj nową nazwę producenta produktu");
                    productList.set(i - 1, editProductBrand(productList.get(i - 1)));
                    break;
                case 3:
                    clearMenu();
                    System.out.println("Podaj nową cenę produktu");
                    productList.set(i - 1, editProductPrice(productList.get(i - 1)));
                    break;
                case 4:
                    System.out.println("Podaj nową kalorykę produktu");
                    productList.set(i - 1, editProductCalories(productList.get(i - 1)));
                    break;
                case 5:
                    clearMenu();
                    System.out.println("Podaj nową nazwę sklepu");
                    productList.set(i - 1, editProductShop(productList.get(i - 1)));
                    break;
                case 6:
                    clearMenu();
                    System.out.println("Podaj nową kategorię produktu:");
                    productList.set(i - 1, editProductCategory(productList.get(i - 1)));
                    break;
                case 7:
                    productList.remove(i-1);
                    return productList;
                case 8:
                    return productList;
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

    public static Product editProductName(Product product) {
        scanner = new Scanner(System.in);
        product.setName(scanner.nextLine());
        return product;
    }

    public static Product editProductBrand(Product product) {
        scanner = new Scanner(System.in);
        product.setBrand(scanner.nextLine());
        return product;
    }

    public static Product editProductPrice(Product product) {
        scanner = new Scanner(System.in);
        product.setPrice(scanner.nextInt());
        return product;
    }

    public static Product editProductCalories(Product product) {
        scanner = new Scanner(System.in);
        product.setCalories(scanner.nextInt());
        return product;
    }

    public static void showValuesOfShop() {
        System.out.println("Wybierz numer przypisany do nazwy sklepu jaki byś chciał nadać edytowanemu produktowi:");
        for (int i = 0; i < Shop.values().length; i++) {
            System.out.println((i + 1) + ". " + Shop.values()[i]);
        }
    }

    public static Product editProductShop(Product product) {
        showValuesOfShop();
        scanner = new Scanner(System.in);
        product.setShop(Shop.values()[scanner.nextInt()-1]);
        return product;
    }

    public static void showValuesOfProductCategory() {
        System.out.println("Wybierz numer kategorii jaką byś chciał nadać edytowanemu produktowi:");
        for (int i = 0; i < ProductCategory.values().length; i++) {
            System.out.println((i + 1) + ". " + ProductCategory.values()[i]);
        }
    }

    public static Product editProductCategory(Product product) {
        showValuesOfProductCategory();
        scanner = new Scanner(System.in);
        product.setProductCategory(ProductCategory.values()[scanner.nextInt()-1]);
        return product;
    }
}
