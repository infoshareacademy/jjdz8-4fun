package pl.fourfun.menutypes;

import pl.fourfun.JsonConverter;
import pl.fourfun.datatypes.Product;
import pl.fourfun.datatypes.ProductCategory;
import pl.fourfun.datatypes.ProductList;
import pl.fourfun.datatypes.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditProductMenu {
    private static int numberOfProduct;
    private static Scanner scanner;

    public static void editingProductMethod() {
        scanner = new Scanner(System.in);
        ProductList productList = JsonConverter.readProductsJsonFile();

        while (true) {
            System.out.println("Twoja list produktów: ");
            for (int i = 0; i < productList.size(); i++) {
                System.out.println();
                System.out.println("Produkt numer " + (i + 1) + ": ");
                System.out.println("Nazwa: " + productList.get(i).getName());
                System.out.println("Brand: " + productList.get(i).getBrand());
                System.out.println("Cena: " + productList.get(i).getPrice());
                System.out.println("Kaloryka: " + productList.get(i).getCalories());
                System.out.println("Sklep: " + productList.get(i).getShop());
                System.out.println("Kategoria produktu: " + productList.get(i).getProductCategory());
            }

            do {
                System.out.println();
                System.out.println("Wybierz numer produktu na liście, który chcesz edytować lub wciśnij 0 by wrócić do menu Administratora : ");
                System.out.println();
                numberOfProduct = scanner.nextInt();
            } while (numberOfProduct > 2 || numberOfProduct < -1);
            if(numberOfProduct == 0){
                JsonConverter.saveProductsToJsonFile(productList);
                return;
            }
            productList = editingChosenProduct(productList, numberOfProduct);
        }
    }
    public static ProductList editingChosenProduct (ProductList productList, int i) {
        while (true) {
            System.out.println("Edytujesz produkt: " + productList.get(i-1).getName());
            System.out.println();
            System.out.println("Wybierz jaką wartość tego produktu chciałbyś edytować : ");
            System.out.println("1. Edytuj nazwę ");
            System.out.println("2. Edytuj brand ");
            System.out.println("3. Edytuj cenę ");
            System.out.println("4. Edytuj kalorykę ");
            System.out.println("5. Edytuj sklep");
            System.out.println("6. Edytuj kategorię produktu");
            System.out.println("7. Wróć do wyboru produktów ");

            int chooseActionNumber = scanner.nextInt();
            do {
                chooseAction(chooseActionNumber);
            } while (chooseActionNumber > 7 || chooseActionNumber < 0);

            switch (chooseActionNumber) {
                case 1:
                    productList.set(i-1, editProductName(productList.get(i-1)));
                    break;
                case 2:
                    productList.set(i-1, editProductBrand(productList.get(i-1)));
                    break;
                case 3:
                    productList.set(i-1, editProductPrice(productList.get(i-1)));
                    break;
                case 4:
                    productList.set(i-1, editProductCalories(productList.get(i-1)));
                    break;
                case 5:
                    productList.set(i-1, editProductShop(productList.get(i-1)));
                    break;
                case 6:
                    productList.set(i-1, editProductCategory(productList.get(i-1)));
                    break;
                case 7:
                    return productList;
            }
        }
    }

    public static Product editProductName(Product product){
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

    public static Product editProductShop(Product product) {
        scanner = new Scanner(System.in);
        product.setShop(Shop.valueOf(scanner.nextLine()));
        return product;
    }

    public static Product editProductCategory(Product product){
        scanner = new Scanner(System.in);
        product.setProductCategory(ProductCategory.valueOf(scanner.nextLine()));
        return product;
    }

    public static void chooseAction(int chosenActionNumber) {
        switch (chosenActionNumber) {
            case 1:
                optionOneEditingAction();
                break;
            case 2:
                optionTwoEditingAction();
                break;
            case 3:
                optionThreeEditingAction();
                break;
            case 4:
                optionFourEditingAction();
                break;
            case 5:
                optionFiveEditingAction();
                break;
            case 6:
                optionSixEditingAction();
                break;
            case 7:
                optionSevenEditingAction();
                break;
        }
    }

    public static void optionOneEditingAction() {
        System.out.println("Edytuj nazwę produktu");
    }

    public static void optionTwoEditingAction() {
        System.out.println("Edytuj brand produktu");
    }

    public static void optionThreeEditingAction() {
        System.out.println("Edytuj cenę produktu");
    }

    public static void optionFourEditingAction() {
        System.out.println("Edytuj kalorykę produktu");
    }

    public static void optionFiveEditingAction() {
        System.out.println("Edytuj sklep");
    }

    public static void optionSixEditingAction() {
        System.out.println("Edytuj kategorię produktu");
    }

    public static void optionSevenEditingAction() {
        System.out.println("Wróć do menu Administratora");
    }
}
