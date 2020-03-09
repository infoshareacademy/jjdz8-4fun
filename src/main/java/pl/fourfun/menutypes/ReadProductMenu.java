package pl.fourfun.menutypes;

import pl.fourfun.readwriteproducts.ReadProducts;

import java.io.IOException;
import java.util.Scanner;

public class ReadProductMenu {

    public static void readingProductMenu() throws IOException {

        int optionMenu = 0;
        boolean counter = false;

        System.out.println("MENU - wyswietlenie produktow: ");
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
                    System.out.println("wczytanie pelnej listy produktow.");
                    ReadProducts.readAllProducts();
                    counter = true;
                    break;
                case 2:
                    System.out.println("wczytanie listy produktow dla wskazanej kategorii.");
                    counter = true;
                    break;
                case 3:
                    System.out.println("powrot do poprzedniego menu.");
                    LoggedUserMenu.showUserMenu();
                    counter = true;
                    break;
                default: {
                    System.out.println("Niepoprawna operacja, wskaz prawidlowa (1,2,3)");
                    break;
                }
            }
        }
    }
}
