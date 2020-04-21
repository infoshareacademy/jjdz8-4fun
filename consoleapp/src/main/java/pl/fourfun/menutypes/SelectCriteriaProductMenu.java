package pl.fourfun.menutypes;

import pl.fourfun.readwriteproducts.ReadProducts;

import java.io.IOException;
import java.util.Scanner;

public class SelectCriteriaProductMenu {

    public static void selectingCriteriaProductMenu() throws IOException, InterruptedException {

        int optionMenu = 0;
        boolean counter = false;

        System.out.println("===== menu Wyszukiwanie produktów względem kryteriów =====");
        System.out.println("1 - wyszukanie listy produktów dla wskazanej kategorii.");
        System.out.println("2 - wyszukanie listy produktów dla podanej nazwy.");
        System.out.println("3 - wyszukanie listy produktów dla wskazanego producenta.");
        System.out.println("4 - wyszukanie listy produktów dla wskazanego sklepu.");
        System.out.println("5 - powrót do poprzedniego menu.");
        while (!counter) {
            Scanner userInputOption = new Scanner(System.in);
            try {
                optionMenu = userInputOption.nextInt();
            } catch (Exception e) {
            }
            switch (optionMenu) {
                case 1:
                    System.out.println("wyszukanie listy produktów dla wskazanej kategorii.");
                    ReadProducts.readChoiceCategoryProducts();
                    counter = true;
                    break;
                case 2:
                    System.out.println("wyszukanie listy produktów dla podanej nazwy.");
                    ReadProducts.readChoiceNameProducts();
                    counter = true;
                    break;
                case 3:
                    System.out.println("wyszukanie listy produktów dla wskazanego producenta.");
                    ReadProducts.readChoiceBrandProducts();
                    counter = true;
                    break;
                case 4:
                    System.out.println("wyszukanie listy produktów dla wskazanego sklepu.");
                    ReadProducts.readChoiceShopProducts();
                    counter = true;
                    break;
                case 5:
                    System.out.println("powrót do głównego menu.");
                    LoggedAdminMenu.showAdminMenu();
                    counter = true;
                    break;
                default: {
                    System.out.println("Niepoprawna operacja, wskaż prawidłowa (1-5)");
                    break;
                }
            }
        }
    }
}
