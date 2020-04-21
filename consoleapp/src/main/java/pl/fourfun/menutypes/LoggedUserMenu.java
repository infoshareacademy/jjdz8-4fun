package pl.fourfun.menutypes;

import pl.fourfun.readwriteproducts.AddProductJson;

import java.io.IOException;
import java.util.Scanner;

import static pl.fourfun.menutypes.Menu.clearMenu;

public class LoggedUserMenu {
    static Scanner inputUserValue = new Scanner(System.in);

    public static void showUserMenu() throws IOException, InterruptedException {
        while (true) {

            int chosenUserMenuNumber = 0;

            clearMenu();
            userMenu();

            do {
                try {
                    System.out.println("\nUżytkowniku wybierz czynność:");
                    chosenUserMenuNumber = inputUserValue.nextInt();

                } catch (Exception e) {
                    inputUserValue.next();
                }
            }

            while ((3 < chosenUserMenuNumber) || (chosenUserMenuNumber < 0));

            switch (chosenUserMenuNumber) {
                case 1:
                    clearMenu();
                    ReadProductMenu.readingUserProductMenu();
                    break;
                case 2:
                    clearMenu();
                    ReadProductMenu.readingAddedUserProductMenu();
                    break;
                case 3:
                    Menu.showMainMenu();
            }
        }
    }

    public static void userMenu() {
        System.out.print("\nUżytkowniku! Poniżej masz zakres czynności do wyboru: \n1. Wyświetl swoją listę zakupów \n2. Zarządzaj swoją listą zakupów \n3. Wróć do menu głównego");
    }
}
